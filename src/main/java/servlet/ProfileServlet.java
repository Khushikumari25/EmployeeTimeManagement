package Employee.Time.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Simulated employee data (this should be replaced with real database operations)
    private static Map<Integer, Employee> employeeData = new HashMap<>();

    // Simulate employee data loading (replace with database later)
    static {
        employeeData.put(1, new Employee(1, "John Doe", "john.doe@example.com", "Software Engineer"));
        employeeData.put(2, new Employee(2, "Jane Smith", "jane.smith@example.com", "HR Manager"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeData.get(employeeId);

        if (employee == null) {
            request.setAttribute("message", "Employee not found.");
        } else {
            request.setAttribute("employee", employee);
        }

        // Forward to the profile.jsp page to display the employee profile
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeData.get(employeeId);

        if (employee == null) {
            request.setAttribute("message", "Employee not found.");
        } else {
            // Update profile details from form data
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String position = request.getParameter("position");

            // Update employee profile
            employee.setName(name);
            employee.setEmail(email);
            employee.setPosition(position);

            request.setAttribute("message", "Profile updated successfully.");
            request.setAttribute("employee", employee);
        }

        // Forward to the profile.jsp page to display the updated profile
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
        dispatcher.forward(request, response);
    }
}

