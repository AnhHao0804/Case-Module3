<%--
  Created by IntelliJ IDEA.
  User: tienm
  Date: 8/5/2024
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>User Name</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listUsers}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button onclick="window.location.href='http://localhost:8080'">Trở lại Trang Chủ</button>
</body>
</html>
