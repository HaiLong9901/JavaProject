<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/30/2023
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách quản lý kho</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div class="accountList_container">
        <div class="heading">
            <h3>Danh sách quản lý kho: ${name}</h3>
        </div>

        <p style="color: red;">${errorString}</p>
        <table >
            <tr>
                <th>Mã quản lý</th>
                <th>Tên quản lý</th>
                <th>Tên đăng nhập</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Sửa</th>
                <th>Xóa</th>
            </tr>
            <c:forEach items="${accountList}" var="account" >
                <tr>
                    <td>${account.userId}</td>
                    <td>${account.fullName}</td>
                    <td>${account.userName}</td>
                    <td>${account.email}</td>
                    <td>${account.phone}</td>
                    <td>
                        <a href="edit?userId=${account.userId}" class="edit-btn">Sửa</a>
                    </td>
                    <td>
                        <a href="delete?userId=${account.userId}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="button">
            <a href="${pageContext.request.contextPath}/account/create" >Thêm quản lý</a>
        </div>

    </div>
</div>

</body>
</html>
