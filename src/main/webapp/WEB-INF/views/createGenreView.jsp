<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/5/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm phân loại</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
    <style><%@include file="/WEB-INF/style/formStyle.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div class="form_container">
        <h3>Thêm phân loại</h3>
        <i class="errorString">${errorString}</i>
        <form method="POST" action="${pageContext.request.contextPath}/product/genre/add" class="form">
            <div class="form_input">
                <label for="name">Tên phân loại</label>
                <input type="text" name="name" id="name" required>
            </div>
            <div class="form_button">
                <input type="submit" value="Tạo">
                <a href="${pageContext.request.contextPath}/product/createProduct" class="link_button">Quay lại</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
