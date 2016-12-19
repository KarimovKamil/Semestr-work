<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 15.12.2016
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Add operation</title>
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
    <h2>Fill all fields</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="customerId">Customer id:</label>
                <input type="number" class="form-control" required value="0" id="customerId" name="customerId"
                       placeholder="Enter customer id">
            </div>
            <div class="form-group">
                <label for="goodsType">Goods type:</label>
                <input type="text" class="form-control" required name="goodsType" id="goodsType"
                       placeholder="Enter goods type">
            </div>
            <div class="form-group">
                <label for="goodsDescription">Goods description:</label>
                <input type="text" class="form-control" name="goodsDescription" id="goodsDescription"
                       placeholder="Enter goods description">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" required value="0" name="price" id="price"
                       placeholder="Enter price of goods">
            </div>
            <div class="form-group">
                <label for="timeOfReturn">Time of return:</label>
                <input type="number" class="form-control" required value="10" name="timeOfReturn" id="timeOfReturn"
                       placeholder="Enter time of return">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
