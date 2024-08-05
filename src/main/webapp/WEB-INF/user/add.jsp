<%--
  Created by IntelliJ IDEA.
  User: tienm
  Date: 8/5/2024
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm Người Dùng Mới</h1>
<form action="users?action=add" method="post">
    <input type="hidden" name="action" value="add">

    <label for="username">Tài khoản:</label>
    <input type="text" id="username" name="userName" required><br>

    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="roleName">Tên Role:</label>
    <input type="text" id="roleName" name="roleName" required><br>

    <input type="submit" value="Thêm Người Dùng">
</form>
</body>
</html>
