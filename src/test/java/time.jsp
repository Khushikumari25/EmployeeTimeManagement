<!-- time.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Record Time</title>
</head>
<body>
    <h1>Record Work Hours</h1>
    <form action="employee" method="post">
        <label for="employeeId">Employee ID:</label>
        <input type="text" id="employeeId" name="employeeId" required><br><br>
        <label for="hoursWorked">Hours Worked:</label>
        <input type="text" id="hoursWorked" name="hoursWorked" required><br><br>
        <input type="submit" value="Submit">
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>