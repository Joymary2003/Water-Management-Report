package com.example;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {
    private ReportDAO reportDAO;

    @Override
    public void init() throws ServletException {
        super.init(); // Call the superclass init method
        reportDAO = new ReportDAO(); // Initialize the ReportDAO instance
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String description = request.getParameter("description");

        // Create a new Report object
        Report newReport = new Report(0, name, location, description);
        try {
            // Insert the report into the database
            reportDAO.insertReport(newReport);
            response.sendRedirect("report.jsp"); // Redirect after successful insertion
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Send error response
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Report> reports;
        try {
            // Retrieve all reports from the database
            reports = reportDAO.selectAllReports();
            request.setAttribute("reports", reports); // Set reports as request attribute
            request.getRequestDispatcher("report.jsp").forward(request, response); // Forward to the JSP
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Send error response
        }
    }
}
