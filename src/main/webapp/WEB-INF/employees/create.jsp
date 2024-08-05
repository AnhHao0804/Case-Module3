<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/5/2024
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h2>Create New Employee</h2>
    <form action="/employees?action=create" method="post">
        <div class="mb-3">
            <label for="cccd" class="form-label">CCCD</label>
            <input type="text" class="form-control" id="cccd" name="cccd" required>
        </div>
        <div class="mb-3">
            <label for="phoneNumber" class="form-label">Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="mb-3">
            <label for="userName" class="form-label">Username</label>
            <input type="text" class="form-control" id="userName" name="userName" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="mb-3">
            <label for="roleId" class="form-label">Role</label>
            <select class="form-select" id="roleId" name="roleId" required>
                <option value="1">ROLE_ADMIN</option>
                <option value="2">ROLE_MANAGER</option>
                <option value="3">ROLE_EMPLOYEE</option>
                <option value="4">ROLE_CUSTOMER</option>
                <option value="5">ROLE_USER</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>
