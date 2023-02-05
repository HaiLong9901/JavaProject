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
  <title>Danh sách API</title>
  <style><%@include file="/WEB-INF/style/index.css"%></style>
  <style><%@include file="/WEB-INF/style/formStyle.css"%></style>
</head>
<body>
<div class="container">
  <%@include file="../../fragment/dashboard.jsp"%>
  <div class="form_container">
    <h3>Danh sách API</h3>
    <i class="errorString">${errorString}</i>
    <form class="form">
      <div class="form_input">
        <label>Lấy tất cả sản phẩm</label>
        <input type="text" disabled value="http://localhost:8080/newweb_war_exploded/api/product">
      </div>
      <div class="form_input">
        <label>Lấy sản phẩm theo mã</label>
        <input type="text" disabled value="http://localhost:8080/newweb_war_exploded/api/product?code=<productCode>">
      </div>
      <div class="form_input">
        <label>Lấy sản phẩm theo phân loại</label>
        <input type="text" disabled value="http://localhost:8080/newweb_war_exploded/api/product?genreId=<genreId>">
      </div>
      <div class="form_input">
        <label>Lấy sản phẩm theo Thuowng hiệu</label>
        <input type="text" disabled value="http://localhost:8080/newweb_war_exploded/api/product?brandId=<brandId>">
      </div>
      <div class="form_input">
        <label>Lấy danh sách phân loại</label>
        <input type="text" disabled value="http://localhost:8080/newweb_war_exploded/api/genres" />
      </div>
      <div class="form_input">
        <label>Lấy danh sách phân loại</label>
        <input type="text" disabled value="http://localhost:8080/newweb_war_exploded/api/genres" />
      </div>
    </form>
  </div>
</div>

</body>
</html>

