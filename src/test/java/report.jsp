<!-- report.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Report</title>
</head>
<body>
    <h1>Employee Report</h1>
    <ul>
        <c:forEach var="employee" items="${employees}">
            <li>${employee}</li>
        </c:forEach>
    </ul>
    <a href="admin.jsp">Back to Admin Dashboard</a>
</body>
</html>