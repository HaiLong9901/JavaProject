<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/22/2023
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa sản phẩm</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
    <style><%@include file="/WEB-INF/style/productListView.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div>
        <h3>Sửa sản phẩm</h3>
        <c:if test="${not empty product}">
        <form method="POST" action="${pageContext.request.contextPath}/product/editProduct" enctype="multipart/form-data">
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
            <label for="brand">
                hang
            </label>
            <select name="brand" id="brand" value="${product.brand}">
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand.brandId}">${brand.name}</option>
                </c:forEach>
            </select>

            <div></div>
            <div>
                <label for="genre">
                    loai
                </label>
                <select name="genre" id="genre" value="${product.genre}">
                    <c:forEach items="${genreList}" var="genre">
                        <option value="${genre.genreId}">${genre.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="desc">Mô tả</label>
                <input type="text" value="${product.product_desc}" id="desc" name="desc">
            </div>
            <div>
                <label for="image">Upload</label>
                <input type="file" value="${product.image}" id="image" name="image">
            </div>
            <input type="submit" value="Submit" />
            <a href="productList">Cancel</a>
        </form>
</c:if>
<%--        <h2>${hello}</h2>--%>
<%--        <ul>--%>
<%--            <c:forEach items="${list}" var="item">--%>
<%--                <li>${item}</li>--%>
<%--            </c:forEach>--%>
<%--            <c:forEach items="${genreList}" var="gen">--%>
<%--                <li>${gen.name}</li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
    </div>
</div>
</body>
</html>
