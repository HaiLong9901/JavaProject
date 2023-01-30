<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/26/2023
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
    <style><%@include file="/WEB-INF/style/productListView.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div>
        <h3>${errorString}</h3>
        <a href="/product/productList">Danh sách sản phẩm</a>
    </div>
</div>
</body>
</html>
