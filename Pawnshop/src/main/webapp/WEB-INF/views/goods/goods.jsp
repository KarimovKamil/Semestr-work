<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 14.12.2016
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Goods</title>
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
            <th>Type</th>
            <th>Price</th>
            <th>Description</th>
        </tr>
        </thead>
        <c:forEach items="${goods}" var="good">
            <tr>
                <td><a href="/goods/${good.goodsId}">${good.goodsId}</a></td>
                <td>${good.goodsType}</td>
                <td>${good.goodsPrice}</td>
                <td>${good.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">
    <form>
        <center>
            <button class="btn btn-primary" formaction="/goods/add" formmethod="get">
                Add new
            </button>
            <button class="btn btn-primary" formaction="/property/all" formmethod="get">
                Show only properties
            </button>
        </center>
    </form>
</div>
</body>
</html>