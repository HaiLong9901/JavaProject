<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/3/2023
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1"
    />
    <title>Chi tiết hóa đơn</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js" integrity="sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
    <style><%@include file="/WEB-INF/style/detailInvoiceStyle.css"%></style>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <i class="${errorString}">${errorString}</i>
    <div class="detail-container">
        <div id="invoice" style="padding: 2rem; display: flex; flex-direction: column; gap: 1.5rem; border: .1rem gray solid;">
            <h2 style="font-size: 2.5rem;
                       text-transform: uppercase;
                       font-weight: bold;
                       text-align: center;">Hóa đơn nhập</h2>
            <div class="detail-section" style="width: 100%; display: flex; gap: 2rem;">
                <h3 style="font-size: 1.6rem; font-weight: bold;">Người tạo đơn:</h3>
                <span style="font-size: 1.6rem;">${accountName}</span>
            </div>

            <div class="detail-section" style="width: 100%; display: flex; gap: 2rem;">
                <h3 style="font-size: 1.6rem; font-weight: bold;">Đối tác:</h3>
                <span style="font-size: 1.6rem;">${invoice.partner}</span>
            </div>
            <div class="detail-section" style="width: 100%; display: flex; gap: 2rem;">
                <h3 style="font-size: 1.6rem; font-weight: bold;">Ngày tạo: </h3>
                <span style="font-size: 1.6rem;">${invoice.createdAt}</span>
            </div>
            <table class="detail-table" style="border: solid .1rem gray; width: 100%; overflow: auto; border-collapse: collapse;">
                <tr>
                    <th style="font-size: 1.6rem; padding: 1rem; font-weight: bold; color: black; border: black solid .1rem; text-align: center;">Mã sản phẩm</th>
                    <th style="font-size: 1.6rem; padding: 1rem; font-weight: bold; color: black; border: black solid .1rem; text-align: center;">Sản phẩm</th>
                    <th style="font-size: 1.6rem; padding: 1rem; font-weight: bold; color: black; border: black solid .1rem; text-align: center;">Giá</th>
                    <th style="font-size: 1.6rem; padding: 1rem; font-weight: bold; color: black; border: black solid .1rem; text-align: center;">Số lượng</th>
                </tr>
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <td style="font-size: 1.5rem; padding: 1rem; border: solid .1rem gray; text-align: center;">${product.code}</td>
                        <td style="font-size: 1.5rem; padding: 1rem; border: solid .1rem gray; text-align: center;">${product.name}</td>
                        <td style="font-size: 1.5rem; padding: 1rem; border: solid .1rem gray; text-align: center;">${product.originalPrice}</td>
                        <td style="font-size: 1.5rem; padding: 1rem; border: solid .1rem gray; text-align: center;">${product.quantity}</td>
                    </tr>
                </c:forEach>
            </table>
            <div class="detail-total" style="width: 100%; display: flex; justify-content: flex-end; gap: 2rem;">
                <h3 style="font-size: 2rem; font-weight: bold;">Tổng đơn: </h3>
                <span style="font-size: 2rem;">${invoice.amount}</span>
            </div>
        </div>
        <div class="button-group">
            <button id="download-button">Tải hóa đơn</button>
            <a href="${pageContext.request.contextPath}/invoice/import/list">Quay lại</a>
        </div>

    </div>
</div>
<script>
  const buttonDownload = document.getElementById('download-button');

  function generatePDF() {
    // Choose the element that your content will be rendered to.
    const element = document.getElementById('invoice');
    // Choose the element and save the PDF for your user.
    html2pdf().from(element).save();
  }

  buttonDownload.addEventListener('click', generatePDF);
</script>
</body>
</html>
