<%@ page import="java.util.List" %>
<%@ page import="com.example.Report" %>

<%
    List<Report> reports = (List<Report>) request.getAttribute("reports");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reported Cases</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Reported Cases</h1>
    <ul>
        <% for (Report report : reports) { %>
            <li>Name: <%= report.getName() %>, Location: <%= report.getLocation() %>, Description: <%= report.getDescription() %></li>
        <% } %>
    </ul>
</body>
</html>
