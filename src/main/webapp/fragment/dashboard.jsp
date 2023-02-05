<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/1/2023
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        .dashboard {
            width: 15%;
            height: 100vh;
            background-image: linear-gradient( 132.6deg,  rgba(71,139,214,1) 23.3%, rgba(37,216,211,1) 84.7% );
        }
        .dashboard .dashboard__header {
            width: 100%;
            padding: 2rem 0;
        }
        .dashboard .dashboard__header h1 {
            font-size: 2rem;
            color: white;
            text-transform: capitalize;
            font-weight: bold;
            text-align: center;
        }
        .dashboard .dashboard__listFunction {
            display: flex;
            flex-direction: column;
        }
        .dashboard .dashboard__listFunction li{
            list-style: none;
            padding: 2rem;
        }

        .dashboard .dashboard__listFunction a {
            text-decoration: none;
            font-size: 1.6rem;
            color: white;
            padding: 2rem;
        }

        .dashboard .dashboard__listFunction a:hover {
            color: yellow;
        }
        .dashboard__listFunction .sub-invoice {
            display: none;
        }
        .dashboard .dashboard__listFunction .invoice .invoice-hidden {
            display: block;
            padding: 1rem;
            display: flex;
            flex-direction: column;
            /*background-color: darkblue;*/
        }
        /*.dashboard .dashboard__listFunction .invoice .invoice-block {*/
        /*    display: block;*/
        /*}*/
    </style>
</head>
<body>
<div class="dashboard" id="dashboard">
    <div class="dashboard__header">
        <h1>Admin</h1>
    </div>

    <ul class="dashboard__listFunction">
        <li>
            <a href="${pageContext.request.contextPath}/account/list">Tài khoản quản lý</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/product/productList">Quản lý sản phẩm</a>
        </li>
        <li class="invoice">
            <div style="font-size: 1.6rem; padding-left: 2rem; color: white; cursor: pointer;">Hóa đơn <i class="fas fa-caret-down" style="font-size: 1.6rem; color: white"></i></div>
            <div class="sub-invoice invoice-block"><a href="${pageContext.request.contextPath}/invoice/import/list">Hóa đơn nhập hàng</a>
                <a href="${pageContext.request.contextPath}/invoice/export/list">Hóa đơn xuất hàng</a></div>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/listApi">API</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
        </li>
    </ul>
</div>
<script>
    let button = document.querySelector(".invoice");
    let invoiceBox = document.querySelector(".invoice .sub-invoice")
    console.log(invoiceBox)
    let closedInvoice = true
    button.addEventListener("click", () => {
        if (closedInvoice === true) {
            invoiceBox.classList.add("invoice-hidden")
            closedInvoice = false;
            console.log("block");
        } else {
            invoiceBox.classList.remove("invoice-hidden")
            closedInvoice = true;
            console.log("hidden");
        }
    })
</script>
</body>
</html>
