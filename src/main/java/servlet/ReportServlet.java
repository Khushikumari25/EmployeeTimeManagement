package Employee.Time.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // In-memory storage for employee data (you can replace it with a database later)
    private static Map<Integer, Employee> employeeData = new HashMap<>();

    // Simulate employee data loading (replace with real DB later)
    static {
        employeeData.put(1, new Employee(1, "John Doe"));
        employeeData.put(2, new Employee(2, "Jane Smith"));
    }

    // Handle GET requests (show employee time management reports)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("viewReport".equals(action)) {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            Employee employee = employeeData.get(employeeId);

            if (employee != null) {
                String report = generateReport(employee);
                request.setAttribute("report", report);
            } else {
                request.setAttribute("message", "Employee not found.");
            }
        } else if ("viewAllReports".equals(action)) {
            StringBuilder reportBuilder = new StringBuilder();
            for (Employee employee : employeeData.values()) {
                reportBuilder.append(generateReport(employee)).append("<br><br>");
            }
            request.setAttribute("report", reportBuilder.toString());
        } else {
            request.setAttribute("message", "Invalid action.");
        }

        // Forward to the report JSP page to display the results
        RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
        dispatcher.forward(request, response);
    }

    // Helper method to generate a report for a single employee
    private String generateReport(Employee employee) {
        StringBuilder report = new StringBuilder();
        report.append("<h2>Report for Employee: ").append(employee.getName()).append(" (ID: ").append(employee.getEmployeeId()).append(")</h2>");
        report.append("<p>Clock In Time: ").append(employee.getClockInTime()).append("</p>");
        report.append("<p>Clock Out Time: ").append(employee.getClockOutTime()).append("</p>");
        report.append("<p>Total Hours Worked: ").append(employee.getWorkedHours()).append(" hours</p>");
        return report.toString();
    }

    // Handle POST requests (optional, to handle form submissions if needed)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

