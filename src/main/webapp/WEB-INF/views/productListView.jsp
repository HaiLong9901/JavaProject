<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
    <style><%@include file="/WEB-INF/style/productListView.css"%></style>
</head>
<body>
    <div class="container">
        <%@include file="../../fragment/dashboard.jsp"%>
        <div class="productList_container">
            <div class="heading">
                <h3>Danh sách sản phẩm</h3>
            </div>

            <p style="color: red;">${errorString}</p>
            <table >
                <tr>
                    <th>Mã</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá bán</th>
                    <th>Giá gốc</th>
                    <th>Mô tả</th>
                    <th>Thương hiệu</th>
                    <th>Loại hàng</th>
                    <th>Sửa</th>
                    <th>Xóa</th>
                </tr>
                <c:forEach items="${productList}" var="product" >
                    <tr>
                        <td>${product.code}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.originalPrice}</td>
                        <td>${product.product_desc}</td>
                        <td>${product.brand}</td>
                        <td>${product.genre}</td>
                        <td>
                            <a href="editProduct?code=${product.code}" class="edit-btn">Sửa</a>
                        </td>
                        <td>
                            <a href="deleteProduct?code=${product.code}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="button">
                <a href="${pageContext.request.contextPath}/product/createProduct" >Thêm sản phẩm</a>
            </div>

        </div>
    </div>

</body>
</html>
