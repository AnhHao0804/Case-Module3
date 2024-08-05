<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2024
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Employee List</h2>
    <form action="/employees" method="get" class="mb-3">
        <input type="hidden" name="action" value="search">
        <div class="input-group">
            <input type="text" name="name" class="form-control" placeholder="Search by name">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>CCCD</th>
            <th>Phone Number</th>
            <th>Name</th>
            <th>Email</th>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td>${employee.cccd}</td>
                <td>${employee.phoneNumber}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.userName}</td>
                <td>
                    <a href="/employees?action=edit&cccd=${employee.cccd}" class="btn btn-warning">Edit</a>
                    <a href="/employees?action=delete&cccd=${employee.cccd}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
