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
    <style><%@include file="/WEB-INF/style/formStyle.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div class="form_container">
        <h3>Sửa tài khoản quản lý</h3>
        <i class="errorString" >${errorString}</i>
<%--        <c:if test="${not empty acc}" style="width: 100%;">--%>
            <form method="POST" action="${pageContext.request.contextPath}/account/edit" class="form">
                <input type="hidden" name="userId" value="${acc.userId}" />
                <div class="form_input">
                    <label for="fullName">Tên quản lý</label>
                    <input type="text" id="fullName" name="fullName" value="${acc.fullName}">
                </div>
                <div class="form_input">
                    <label for="userName">Tài khoản</label>
                    <input type="text" id="userName" name="userName" value="${acc.userName}">
                </div>
                <div class="form_input">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="${acc.email}">
                </div>
                <div class="form_input">
                    <label for="phone">Số điện thoại</label>
                    <input type="text" value="${acc.phone}" id="phone" name="phone">
                </div>
                <div class="form_button">
                    <input type="submit" value="Sửa" />
                    <a href="list">Quay lại</a>
                </div>
                <input type="hidden" name="count" class="test_input">
            </form>
<%--        </c:if>--%>
    </div>
    <div class="test">
        <h3 class="name0">${acc.userName}</h3>
    </div><span class="add">Add</span>
</div>
<script>
    const test = document.querySelector(".test")
    const add = document.querySelector(".add")
    const count = document.querySelector(".test_input")
    let index = 1
    add.addEventListener("click", () => {
        console.log("click")
        console.log(test.innerHTML)
        test.innerHTML+="<h3 class='name" + index + "'>${acc.userName}</h3>";
        count.value = index;
        console.log({count})
        ++index;
    })
</script>
</body>
</html>
