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
    <style><%@include file="/WEB-INF/style/listStyle.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div class="accountList_container list_container">
        <div class="heading">
            <h3>Danh sách quản lý kho</h3>
            <div style="display: flex; gap: 2rem;">
                <div class="button">
                    <a href="${pageContext.request.contextPath}/account/create" >Thêm quản lý</a>
                </div>
                <div class="button">
                    <a href="${pageContext.request.contextPath}/account/myacc">Tài khoản của tôi</a>
                </div>
            </div>

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

    </div>
</div>

</body>
</html>
