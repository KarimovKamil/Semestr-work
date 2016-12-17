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
    <title>Customers</title>
    <%--<style>--%>
        <%--body {--%>
            <%--background-color: #5bc0de; /* Цвет фона веб-страницы */--%>
        <%--}--%>
    <%--</style>--%>
</head>
<body>
<div class="container">
    <table class="table table-striped table-bordered">
        <thead>
        <tr align="center">
            <th>Id</th>
            <th>Last name</th>
            <th>First name</th>
            <th>Middle name</th>
            <th>Phone number</th>
            <th>Passport</th>
            <th>Date of birth</th>
        </tr>
        </thead>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><a href="/customer/${customer.customerId}">${customer.customerId}</a></td>
                <td>${customer.lastName}</td>
                <td>${customer.firstName}</td>
                <td>${customer.middleName}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.passport}</td>
                <td>${customer.dateOfBirth}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container">
    <form>
        <center>
            <button class="btn btn-primary" formaction="/customer/add" formmethod="get">
                Add new
            </button>
        </center>
    </form>
</div>
</body>
</html>
