<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%--    <jsp:include page="index.css" />--%>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;700&family=Pacifico&family=Roboto:ital,wght@0,400;0,500;0,700;1,400;1,500&display=swap');
    </style>
    <link href="./index.css" rel="stylesheet" type="text/css">
    <style>
        .home {
            width: 100vw;
            display: flex;
        }
    </style>

</head>
<body>
<div class="home">
    <%@include file="../../fragment/dashboard.jsp"%>
</div>
</body>
</html>