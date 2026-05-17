<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>

<%
    User user = (User) session.getAttribute("currentUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<style>

body{
    font-family: Arial;
    background: #f2f2f2;
    padding: 40px;
}

.box{
    width: 500px;
    margin: auto;
    background: white;
    padding: 30px;
    border-radius: 10px;
}

h1{
    color: #2196F3;
}

p{
    font-size: 18px;
}

</style>

</head>
<body>

<div class="box">

    <h1>Dashboard</h1>

    <h3>Đăng nhập thành công!</h3>

    <p>
        Xin chào:
        <b><%= user.getFullName() %></b>
    </p>

    <p>
        Username:
        <%= user.getUsername() %>
    </p>

    <p>
        Email:
        <%= user.getEmail() %>
    </p>

    <p>
        Role:
        <%= user.getRole() %>
    </p>

</div>

</body>
</html>