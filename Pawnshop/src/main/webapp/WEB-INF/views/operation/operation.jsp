<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 14.12.2016
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Operation</title>
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
    <form>
        <h2>Operation information</h2>
        <h3>Id: ${operation.operationId}<br>
            Goods id: <a href="/goods/${operation.goodsId}">${operation.goodsId}</a><br>
            Customer id: <a href="/customer/${operation.customerId}">${operation.customerId}</a><br>
            Pledge date: ${operation.pledgeDate}<br>
            Time of return: ${operation.timeOfReturn}<br>
            Status: ${operation.status}<br>
            Return amount: ${operation.returnAmount}<br>
        </h3>
        <button class="btn btn-primary" formaction="/operation/${operation.operationId}/update"
                formmethod="get">
            Update
        </button>
        <button class="btn btn-primary" formaction="/operation/${operation.operationId}/delete"
                formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/operation/all" formmethod="get">
            Show all
        </button>
    </form>
</div>
</body>
</html>
