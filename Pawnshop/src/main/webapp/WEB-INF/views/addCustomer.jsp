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
    <title>Add customer</title>
</head>
<body>
<div class="container">
    <h2>Fill all fields</h2>
    <form>
        <div class="input-group input-group-lg">
            <div class="form-group">
                <label for="firstName">First name:</label>
                <input type="text" class="form-control" id="firstName" name="firstName"
                       placeholder="Enter first name">
            </div>
            <div class="form-group">
                <label for="lastName">Last name:</label>
                <input type="text" class="form-control" name="lastName" id="lastName"
                       placeholder="Enter last name">
            </div>
            <div class="form-group">
                <label for="middleName">Middle name:</label>
                <input type="text" class="form-control" name="middleName" id="middleName"
                       placeholder="Enter middle name">
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone number:</label>
                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber"
                       placeholder="Enter phone number">
            </div>
            <div class="form-group">
                <label for="passport">Passport:</label>
                <input type="text" class="form-control" name="passport" id="passport"
                       placeholder="Enter passport">
            </div>
            <div class="form-group">
                <label for="dateOfBirth">Date of birth:</label>
                <input type="date" class="form-control" name="dateOfBirth" value="1990-01-01" id="dateOfBirth">
            </div>
        </div>
        <br>
        <button type="submit" formmethod="post" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
