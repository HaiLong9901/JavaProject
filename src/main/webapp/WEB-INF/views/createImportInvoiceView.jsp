<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/2/2023
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo đơn nhập kho</title>
    <style><%@include file="/WEB-INF/style/index.css"%></style>
    <style><%@include file="/WEB-INF/style/formStyle.css"%></style>
    <style><%@include file="/WEB-INF/style/invoiceStyle.css"%></style>
</head>
<body>
    <div class="container">
        <%@include file="../../fragment/dashboard.jsp"%>
        <div class="form_container">
            <h3>Tạo đơn nhập kho</h3>
            <i class="errorString">${errorString}</i>
            <form  method="POST" action="${pageContext.request.contextPath}/invoice/import/add" class="form">
                <div class="form_input">
                    <label for="account">Người tạo đơn</label>
                    <input type="text" id="account" value="${account}" disabled>
                </div>
                <div class="form_input">
                    <label for="partner">Tên đối tác</label>
                    <input type="text" name="partner" id="partner" required>
                </div>
                <div class="form_product">
                    <label for="product">Chọn sản phẩm</label>
                    <div class="addProduct">
                        <select name="product0" id="product">
                            <c:forEach items="${productList}" var="product">
                                <option value="${product.code}">${product.name}</option>
                            </c:forEach>
                        </select>
                        <input type="text" name="quantity0" placeholder="Nhập số lượng" required>
                    </div>
                </div>
                <span class="addButton">Thêm sản phẩm</span>
                <input type="hidden" name="count" class="count">
                <div class="form_button">
                    <input type="submit" value="Tạo đơn">
                    <a href="list">Quay lại</a>
                </div>
            </form>
        </div>
    </div>
    <script>
        const form = document.querySelector(".form_product")
        const addButton  =document.querySelector(".addButton")
        const numberOfProducts = document.querySelector(".count")
        const label = document.querySelector(".form_product label")
        let index =1
        addButton.addEventListener("click", () => {
            console.log("click");
 //           form.innerHTML += "<div class='addProduct'><select name='product" + index +"' + index id='product'><c:forEach items='${productList}' var='product'> <option value='${product.code}'>${product.name}</option></c:forEach> </select> <input type='text' name='quantity" + index +"' placeholder='Nhập số lượng' required></div>"
            const str = "<div class='addProduct'><select name='product" + index +"' + index id='product'><c:forEach items='${productList}' var='product'> <option value='${product.code}'>${product.name}</option></c:forEach> </select> <input type='text' name='quantity" + index +"' placeholder='Nhập số lượng' required></div>"
            form.insertAdjacentHTML("beforeend", str)
            ++index;
            numberOfProducts.value = index
        })
    </script>
</body>
</html>
