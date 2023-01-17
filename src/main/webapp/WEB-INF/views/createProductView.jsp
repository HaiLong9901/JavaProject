<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/16/2023
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
  <style><%@include file="/WEB-INF/style/index.css"%></style>
  <style><%@include file="/WEB-INF/style/productListView.css"%></style>
</head>
<body>
  <div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div>
      <h3>Thêm sản phẩm</h3>
      <form action="POST" action="${pageContext.request.contextPath}/product/createProduct">
        <div>
          <label for="name">Tên sản phẩm</label>
          <input type="text" id="name" name="name" value="${product.name}">
        </div>
        <div>
          <label for="price">Giá bán</label>
          <input type="text" id="price" name="price" value="${product.price}">
        </div>
        <div>
          <label for="originalPrice">Giá goc</label>
          <input type="text" id="originalPrice" name="originalPrice" value="${product.originalPrice}">
        </div>
        <div>
          <label for="brand">
            hang
          </label>
          <select name="brand" id="brand" value="${product.brand}">
            <c:forEach items="${brandList}" var="brand">
              <option value="${brand.brandId}">${brand.name}</option>
            </c:forEach>
          </select>
        </div>
        <div>
          <label for="genre">
            loai
          </label>
          <select name="brand" id="genre" value="${product.genre}">
            <c:forEach items="${genreList}" var="genre">
              <option value="${genre.genreId}">${genre.name}</option>
            </c:forEach>
          </select>
        </div>
        <input type="submit" value="Submit" />
        <a href="productList">Cancel</a>
      </form>
    </div>
  </div>
</body>
</html>
