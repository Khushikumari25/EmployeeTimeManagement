package Employee.Time.Management;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleError(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleError(request, response);
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the exception or error information
        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        String requestUri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);

        // Set content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display the error information to the user
        out.println("<html><head><title>Error Page</title></head><body>");
        out.println("<h2>An error occurred:</h2>");

        if (statusCode != null) {
            out.println("<p><b>Status Code:</b> " + statusCode + "</p>");
        }

        if (throwable != null) {
            out.println("<p><b>Exception Message:</b> " + throwable.getMessage() + "</p>");
        }

        if (errorMessage != null) {
            out.println("<p><b>Error Message:</b> " + errorMessage + "</p>");
        }

        if (requestUri != null) {
            out.println("<p><b>Request URI:</b> " + requestUri + "</p>");
        }

        out.println("<hr>");
        out.println("<p><a href='index.jsp'>Go back to the homepage</a></p>");
        out.println("</body></html>");
    }
}
