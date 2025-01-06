package Employee.Time.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // In-memory storage for employee data (you can replace it with a database later)
    private static Map<Integer, Employee> employeeData = new HashMap<>();

    // Simulate employee data loading (this can be replaced with a real DB call)
    static {
        employeeData.put(1, new Employee(1, "John Doe"));
        employeeData.put(2, new Employee(2, "Jane Smith"));
    }

    // Handle GET requests (show employee time management page)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        // Check action parameter and handle accordingly
        if ("clockIn".equals(action)) {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            Employee employee = employeeData.get(employeeId);

            if (employee != null) {
                employee.clockIn();
                request.setAttribute("message", "Employee " + employee.getName() + " clocked in at: " + employee.getClockInTime());
            } else {
                request.setAttribute("message", "Employee not found.");
            }
        } else if ("clockOut".equals(action)) {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            Employee employee = employeeData.get(employeeId);

            if (employee != null) {
                employee.clockOut();
                request.setAttribute("message", "Employee " + employee.getName() + " clocked out at: " + employee.getClockOutTime());
            } else {
                request.setAttribute("message", "Employee not found.");
            }
        } else {
            request.setAttribute("message", "Welcome to the Employee Time Management System.");
        }

        // Forward to JSP to show the message and employee data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    // Handle POST requests (for form submissions, mainly for clock-in and clock-out)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
