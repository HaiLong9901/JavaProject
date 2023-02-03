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
    <title>Chi tiết hóa đơn</title>
  <style><%@include file="/WEB-INF/style/index.css"%></style>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js" integrity="sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div class="container">
    <%@include file="../../fragment/dashboard.jsp"%>
    <div>
        <div id="invoice">
            <h2>Hóa đơn nhập</h2>
            <div>
                <h3>Người tạo đơn:</h3>
                <span>Do Hai Long</span>
            </div>

            <div>
                <h3>Đối tác:</h3>
                <span>Nguyen Van A</span>
            </div>
            <table>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Sản phẩm</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                </tr>
            </table>
            <div>
                <h3>Tổng đơn: </h3>
                <span>20000</span>
            </div>
        </div>
        <button id="download-button">Download as PDF</button>
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
