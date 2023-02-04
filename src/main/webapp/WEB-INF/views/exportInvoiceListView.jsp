<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2023
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Hóa đơn nhập hàng</title>
  <style><%@include file="/WEB-INF/style/index.css"%></style>
  <style><%@include file="/WEB-INF/style/listStyle.css"%></style>
</head>
<body>
<div class="container">
  <%@include file="../../fragment/dashboard.jsp"%>
  <div class="list_container">
    <div class="heading">
      <h3>Danh sách hóa đơn xuất</h3>
      <div class="button">
        <a href="${pageContext.request.contextPath}/invoice/export/add" >Tạo đơn xuất</a>
      </div>
    </div>

    <i class="errorString">${errorString}</i>
    <table >
      <tr>
        <th>Mã đơn</th>
        <th>Ngày nhập</th>
        <th>Tổng đơn</th>
        <th>Người tạo đơn</th>
        <th>Đối tác</th>
        <th>Xem chi tiết</th>
      </tr>
      <c:forEach items="${invoiceList}" var="invoice" >
        <tr>
          <td>${invoice.invoiceId}</td>
          <td>${invoice.createdAt}</td>
          <td>${invoice.amount}</td>
          <td>${invoice.account}</td>
          <td>${invoice.partner}</td>
          <td>
            <a href="detail?invoiceId=${invoice.invoiceId}" class="edit-btn">Xem chi tiết</a>
          </td>
        </tr>
      </c:forEach>
    </table>


  </div>
</div>

</body>
</html>
