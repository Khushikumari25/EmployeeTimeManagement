package Employee.Time.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class TimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Simulated employee data (replace with real database in production)
    private static Map<Integer, Employee> employeeData = new HashMap<>();

    // Simulate employee data loading (replace with database later)
    static {
        employeeData.put(1, new Employee(1, "John Doe"));
        employeeData.put(2, new Employee(2, "Jane Smith"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeData.get(employeeId);

        if (employee == null) {
            request.setAttribute("message", "Employee not found.");
        } else {
            switch (action) {
                case "clockIn":
                    employee.clockIn();
                    request.setAttribute("message", "Employee " + employee.getName() + " clocked in at: " + employee.getClockInTime());
                    break;
                case "clockOut":
                    employee.clockOut();
                    request.setAttribute("message", "Employee " + employee.getName() + " clocked out at: " + employee.getClockOutTime());
                    break;
                case "viewTime":
                    request.setAttribute("employee", employee);
                    request.setAttribute("workedHours", employee.getWorkedHours());
                    break;
                default:
                    request.setAttribute("message", "Invalid action.");
                    break;
            }
        }

        // Forward the request to the JSP page to display the message or data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/time.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

