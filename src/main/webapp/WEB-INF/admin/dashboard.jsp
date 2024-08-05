<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2024
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Admin Dashboard</h2>
    <a href="employees?action=create" class="btn btn-primary">Add Employee</a>
    <a href="employees?action=list" class="btn btn-info">View Employees</a>
</div>
</body>
</html>

