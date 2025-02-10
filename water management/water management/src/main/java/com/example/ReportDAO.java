package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/water_wastage";
    private String jdbcUsername = "Joymary2003"; // Update with your MySQL username
    private String jdbcPassword = "3754"; // Update with your password

    private static final String INSERT_REPORT_SQL = "INSERT INTO reports (name, location, description) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_REPORTS_SQL = "SELECT * FROM reports ORDER BY created_at DESC";

    public void insertReport(Report report) throws Exception {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REPORT_SQL)) {
            preparedStatement.setString(1, report.getName());
            preparedStatement.setString(2, report.getLocation());
            preparedStatement.setString(3, report.getDescription());
            preparedStatement.executeUpdate();
        }
    }

    public List<Report> selectAllReports() throws Exception {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REPORTS_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                String description = resultSet.getString("description");
                reports.add(new Report(id, name, location, description));
            }
        }
        return reports;
    }
}
