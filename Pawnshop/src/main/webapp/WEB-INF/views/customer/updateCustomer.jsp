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
    <title>Update customer</title>
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
                <label for="firstName">First name:</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="${customer.firstName}">
            </div>
            <div class="form-group">
                <label for="lastName">Last name:</label>
                <input type="text" class="form-control" name="lastName" value="${customer.lastName}" id="lastName">
            </div>
            <div class="form-group">
                <label for="middleName">Middle name:</label>
                <input type="text" class="form-control" name="middleName" value="${customer.middleName}" id="middleName">
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone number:</label>
                <input type="text" pattern="[1-9][0-9]{10}" class="form-control" required name="phoneNumber" value="${customer.phoneNumber}" id="phoneNumber">
            </div>
            <div class="form-group">
                <label for="passport">Passport:</label>
                <input type="text" pattern="[0-9]{10}"  class="form-control" required name="passport" value="${customer.passport}" id="passport">
            </div>
            <div class="form-group">
                <label for="dateOfBirth">Date of birth:</label>
                <input type="date" class="form-control" required name="dateOfBirth" value="${customer.dateOfBirth}" value="1990-01-01" id="dateOfBirth">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
