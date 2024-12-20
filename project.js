// Handle form submission for clock-in/clock-out
async function handleFormSubmit(event) {
    event.preventDefault(); // Prevent page reload

    const employeeId = document.getElementById("employeeId").value.trim();
    const action = document.getElementById("action").value;

    if (!employeeId) {
        updateStatus("Employee ID is required.", "error");
        return;
    }

    try {
        const response = await fetch("http://localhost:8080/api/time-management", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ employeeId, action }),
        });

        const data = await response.json();

        if (response.ok) {
            updateStatus(`Success: ${data.message}`, "success");
            await loadLogs(); // Refresh logs after successful action
        } else {
            updateStatus(`Error: ${data.error}`, "error");
        }
    } catch (error) {
        console.error("Error during submission:", error);
        updateStatus("An unexpected error occurred. Please try again.", "error");
    }

    // Reset form
    document.getElementById("timeForm").reset();
}

// Load time logs and populate the table
async function loadLogs() {
    try {
        const response = await fetch("http://localhost:8080/api/time-management/logs");

        if (!response.ok) {
            updateStatus("Failed to load logs.", "error");
            return;
        }

        const logs = await response.json();
        const logsTableBody = document.getElementById("logsTable").querySelector("tbody");
        logsTableBody.innerHTML = ""; // Clear existing rows

        logs.forEach((log) => {
            const row = logsTableBody.insertRow();
            row.innerHTML = `
                <td>${log.employeeId}</td>
                <td>${log.action}</td>
                <td>${new Date(log.timestamp).toLocaleString()}</td>
            `;
        });
    } catch (error) {
        console.error("Error while loading logs:", error);
        updateStatus("An error occurred while loading logs.", "error");
    }
}

// Update status message for user feedback
function updateStatus(message, type) {
    const statusDiv = document.getElementById("status");
    statusDiv.textContent = message;
    statusDiv.className = type; // Add class for styling (e.g., success or error)
}

// Initialize: Attach event listener and load logs
document.getElementById("timeForm").addEventListener("submit", handleFormSubmit);
window.addEventListener("load", loadLogs);
