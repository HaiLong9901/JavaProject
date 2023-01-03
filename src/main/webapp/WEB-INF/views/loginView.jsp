<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/2/2023
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
    <style><%@include file="/WEB-INF/style/loginView.css"%></style>
</head>
<body>
<div class="login_layout">
    <div class="login_container">
        <form method="POST" action="${pageContext.request.contextPath}/login">
            <h3>Login</h3>
            <p style="color: red;">${errorString}</p>
            <div class="login_input">
                <label for="userName">Name: </label>
                <input type="text" id="userName" name="userName" value="${user.userName}" />
            </div>
            <div class="login_input">
                <label for="password">Password: </label>
                <input type="password" id="password" name="password" value="${user.password}" />
            </div>
            <div class="login_input">
                <label for="rememberMe">Remember Me: </label>
                <input type="checkbox" name="rememberMe" value= "Y" id="rememberMe"/>
            </div>
            <div class="login_submit">
                <input type="submit" value= "Login" />
            </div>
        </form>
    </div>
</div>


</body>
</html>
