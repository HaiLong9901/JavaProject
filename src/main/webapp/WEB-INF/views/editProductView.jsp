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
    <style><%@include file="/WEB-INF/style/formStyle.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div class="form_container">
        <h3>Sửa sản phẩm</h3>
        <c:if test="${not empty product}">
        <form method="POST" action="${pageContext.request.contextPath}/product/editProduct" enctype="multipart/form-data" class="form">
            <input type="hidden" name="code" value="${product.code}" />
            <div class="form_input">
                <label for="name">Tên sản phẩm</label>
                <input type="text" id="name" name="name" value="${product.name}">
            </div>
            <div class="form_input">
                <label for="price">Giá bán</label>
                <input type="text" id="price" name="price" value="${product.price}">
            </div>
            <div class="form_input">
                <label for="originalPrice">Giá nhập</label>
                <input type="text" id="originalPrice" name="originalPrice" value="${product.originalPrice}">
            </div>
            <div class="form_input">
                <label for="brand">
                    Thương hiệu
                </label>
                <select name="brand" id="brand" value="${product.brand}">
                    <c:forEach items="${brandList}" var="brand">
                        <c:choose>
                            <c:when test="${brand.brandId == product.brand}">
                                <option value="${brand.brandId}" selected>${brand.name}</option>
                            </c:when>
                            <c:when test="${brand.brandId != product.brand}">
                                <option value="${brand.brandId}">${brand.name}</option>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form_input">
                <label for="genre">
                    Phân loại
                </label>
                <select name="genre" id="genre" value="${product.genre}">
                    <c:forEach items="${genreList}" var="genre">
                        <c:choose>
                            <c:when test="${genre.genreId == product.genre}">
                                <option value="${genre.genreId}" selected>${genre.name}</option>
                            </c:when>
                            <c:when test="${genre.genreId != product.genre}">
                                <option value="${genre.genreId}">${genre.name}</option>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
            <div class="form_input">
                <label for="desc">Thông số</label>
                <input type="text" value="${product.product_desc}" id="desc" name="desc">
            </div>
            <div class="form_input">
                <label for="image">Upload</label>
                <input type="file" value="${product.image}" id="image" name="image">
            </div>
            <div class="form_button">
                <input type="submit" value="Submit" />
                <a href="productList">Cancel</a>
            </div>

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
