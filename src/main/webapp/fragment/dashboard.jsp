<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/1/2023
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .dashboard {
            width: 15%;
            height: 100vh;
            background-color: dodgerblue;
        }
        .dashboard .dashboard__header {
            width: 100%;
            padding: 2rem 0;
        }
        .dashboard .dashboard__header h1 {
            font-size: 2rem;
            color: white;
            text-transform: capitalize;
            font-weight: bold;
            text-align: center;
        }
        .dashboard .dashboard__listFunction {
            display: flex;
            flex-direction: column;
        }
        .dashboard .dashboard__listFunction li{
            list-style: none;
            padding: 2rem;
        }

        .dashboard .dashboard__listFunction a {
            text-decoration: none;
            font-size: 1.6rem;
            color: white;
            padding: 2rem;
        }

        .dashboard .dashboard__listFunction a:hover {
            color: yellow;
        }
    </style>
</head>
<body>
<div class="dashboard" id="dashboard">
    <div class="dashboard__header">
        <h1>Admin</h1>
    </div>

    <ul class="dashboard__listFunction">
        <li>
            <a href="${pageContext.request.contextPath}/productList">Người dùng</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/productList">Sản phẩm</a>
        </li>
        <li>
            <a href="/">Thống kê</a>
        </li>
        <li>
            <a href="/">Đăng xuất</a>
        </li>
    </ul>
</div>
</body>
</html>
