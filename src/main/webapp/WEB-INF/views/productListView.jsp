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
            <h3>Product List</h3>

            <p style="color: red;">${errorString}</p>
            <c:forEach items="${productList}" var="product">
                <h3>${product.name}</h3>
            </c:forEach>

            <table >
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${productList}" var="product" >
                    <tr>
                        <td>${product.code}</td>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>
                            <a href="editProduct?code=${product.code}">Edit</a>
                        </td>
                        <td>
                            <a href="deleteProduct?code=${product.code}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <a href="createProduct" >Create Product</a>
        </div>
    </div>

</body>
</html>
