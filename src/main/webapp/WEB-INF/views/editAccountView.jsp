<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/1/2023
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa tài khoản quản lý</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div>
        <h3>Sửa sản phẩm</h3>
        <c:if test="${not empty acc}">
            <form method="POST" action="${pageContext.request.contextPath}/account/edit">
                <input type="text" name="userId" value="${acc.userId}" />
                <h3>${acc.userId}</h3>
                <div>
                    <label for="ID">ID</label>
                    <input type="text" name="ID" id="ID" value="${acc.userId}" disabled>
                </div>
                <div>
                    <label for="fullName">Tên quản lý</label>
                    <input type="text" id="fullName" name="fullName" value="${acc.fullName}">
                </div>
                <div>
                    <label for="userName">Tài khoản</label>
                    <input type="text" id="userName" name="userName" value="${acc.userName}">
                </div>
                <div>
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="${acc.email}">
                </div>
                <div>
                    <label for="phone">Số điện thoại</label>
                    <input type="text" value="${user.phone}" id="phone" name="phone">
                </div>
                <input type="submit" value="Submit" />
                <a href="list">Cancel</a>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>
