<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 17.12.2016
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Update operation</title>
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
    <h2>Enter new values</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="customerId">Customer id:</label>
                <input type="number" class="form-control" id="customerId" name="customerId" value="${operation.customerId}">
            </div>
            <div class="form-group">
                <label for="timeOfReturn">Time of return:</label>
                <input type="number" class="form-control" name="timeOfReturn" value="${operation.timeOfReturn}" id="timeOfReturn">
            </div>
            <div class="form-group">
                <label for="status">Status:</label>
                <input type="text" class="form-control" name="status" value="${operation.status}" id="status">
            </div>
            <div class="form-group">
                <label for="returnAmount">Return amount:</label>
                <input type="number" class="form-control" name="returnAmount" value="${operation.returnAmount}" id="returnAmount">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
