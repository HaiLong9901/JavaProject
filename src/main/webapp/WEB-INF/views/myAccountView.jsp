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
  <style><%@include file="/WEB-INF/style/index.css"%></style>
  <style><%@include file="/WEB-INF/style/formStyle.css"%></style>
</head>
<body>
<div class="container">
  <%@include file="../../fragment/dashboard.jsp"%>
  <div class="form_container">
    <h3>Tài khoản của tôi</h3>
    <i class="errorString">${errorString}</i>
    <form method="POST" action="${pageContext.request.contextPath}/account/myacc" class="form">
      <div class="form_input">
        <label for="fullName">Tên quản lý</label>
        <input type="text" id="fullName" name="fullName" value="${acc.fullName}">
      </div>
      <div class="form_input">
        <label for="userName">Tên đăng nhập</label>
        <input type="text" id="userName" name="userName" value="${acc.userName}" disabled>
      </div>
      <div class="form_input">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="${acc.email}">
      </div>
      <div class="form_input">
        <label for="phone">Số điện thoại</label>
        <input type="text" value="${acc.phone}" id="phone" name="phone">
      </div>
      <div class="form_input">
        <label for="password">Mật khẩu</label>
        <input type="password" value="${acc.password}" id="password" name="password">
      </div>
      <div class="form_input">
        <label for="confirm">Xác nhận mật khẩu</label>
        <input type="password" value="${acc.password}" id="confirm" name="confirm">
      </div>



      <div class="form_button">
        <input type="submit" value="Cập nhật" />
        <a href="list">Quay lại</a>
      </div>

    </form>
  </div>
</div>

</body>
</html>
