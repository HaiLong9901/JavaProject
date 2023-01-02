<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/22/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="./fragment/header.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="header-wrapper">
    <div class="wrapper">
        <div class="header">
            <h1>Tastyfood</h1>
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/productList">Products List</a></li>
                <li><a href="${pageContext.request.contextPath}/userinfo">User Info</a></li>
                <li><a href="${pageContext.request.contextPath}/login">Log in</a></li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>