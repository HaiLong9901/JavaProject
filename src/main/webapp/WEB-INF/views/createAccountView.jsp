<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/30/2023
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo tài khoản quản lý</title>
</head>
<body>
<div class="container">
  <%@include file="../../fragment/dashboard.jsp"%>
  <div>
    <h3>Tạo tài khoản quản lý</h3>
    <form method="POST" action="${pageContext.request.contextPath}/account/create">
      <div>
        <label for="fullName">Tên quản lý</label>
        <input type="text" id="fullName" name="fullName" value="${acc.fullName}">
      </div>
      <div>
        <label for="userName">Tên đăng nhập</label>
        <input type="text" id="userName" name="userName" value="${acc.userName}">
      </div>
      <div>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="${acc.email}">
      </div>
      <div>
        <label for="phone">Số điện thoại</label>
        <input type="text" value="${acc.phone}" id="phone" name="phone">
      </div>
      <input type="submit" value="Submit" />
      <a href="productList">Cancel</a>
    </form>
  </div>
</div>
</body>
</html>
