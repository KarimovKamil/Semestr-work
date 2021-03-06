<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 17.12.2016
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Operations</title>
    <%--<style>--%>
    <%--body {--%>
    <%--background-color: #5bc0de; /* Цвет фона веб-страницы */--%>
    <%--}--%>
    <%--</style>--%>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Pawnshop</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/operation/all">Operations</a></li>
            <li><a href="/customer/all">Customers</a></li>
            <li><a href="/goods/all">Goods</a></li>
            <li><a href="/property/all">Properties</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Id</th>
            <th>Goods id</th>
            <th>Customer id</th>
            <th>Pledge date</th>
            <th>Time of return</th>
            <th>Status</th>
            <th>Return amount</th>
        </tr>
        </thead>
        <c:forEach items="${operations}" var="operation">
            <tr>
                <td><a href="/operation/${operation.operationId}">${operation.operationId}</a></td>
                <td><a href="/goods/${operation.goodsId}">${operation.goodsId}</a></td>
                <td><a href="/customer/${operation.customerId}">${operation.customerId}</a></td>
                <td>${operation.pledgeDate}</td>
                <td>${operation.timeOfReturn}</td>
                <td>${operation.status}</td>
                <td>${operation.returnAmount}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">
    <form>
        <center>
            <button class="btn btn-primary" formaction="/operation/add" formmethod="get">
                Add new
            </button>
        </center>
    </form>
</div>
</body>
</html>
