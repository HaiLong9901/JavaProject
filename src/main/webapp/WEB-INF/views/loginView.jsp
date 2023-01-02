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
    <title>Title</title>
    <style>
        * {
            margin: 0;
            font-size: 10px;
            font-family: Roboto, sans-serif;
        }
        .login_layout {
            width: 100vw;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login_layout .login_container {
            width: 30%;
            height: 60%;
            border: solid .1rem black;
            border-radius: .5rem;
            padding: 3rem;
        }
        .login_container form {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        .login_container h3 {
            font-size: 2.5rem;
            font-weight: bold;
            text-align: center;
        }
        .login_container p {
            font-size: 1.6rem;
        }
        .login_container .login_input {
            width: 100%;
            display: flex;
            justify-content: space-between;
        }
        .login_input label {
            font-size: 1.6rem;
        }
        .login_input input {
            width: 60%;
            outline: none;
            border: solid .1rem black;
            border-radius: .5rem;
            padding: .5rem;
            font-size: 1.6rem;
        }
        .login_submit {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login_submit input {
            outline: none;
            background-color: dodgerblue;
            font-size: 1.6rem;
            transition: .2s;
            border: none;
            padding: 1rem 3rem;
            border-radius: .5rem;
            cursor: pointer;
        }
        .login_submit input:hover{
            background-color: red;
            color: white;
        }
    </style>
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
