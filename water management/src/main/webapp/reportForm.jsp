<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Submit Report</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Water Wastage Report</h1>
    <form action="report" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea>

        <button type="submit">Submit Report</button>
    </form>
    <a href="report">View Reports</a>
</body>
</html>
