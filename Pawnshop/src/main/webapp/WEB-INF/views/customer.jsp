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
    <title>Customer</title>
</head>
<body>
<div class="container">
    <form>
        <h2>Information</h2>
        <h4>Id: ${customer.customerId}<br>
            Last name: ${customer.lastName}<br>
            First name: ${customer.firstName}<br>
            Middle name: ${customer.middleName}<br>
            Phone: ${customer.phoneNumber}<br>
            Passport: ${customer.passport}<br>
            Date of birth: ${customer.dateOfBirth}<br>
        </h4>
        <%--<div class="container">--%>
        <button class="btn btn-primary" formaction="/customer/${customer.customerId}/update"
                formmethod="get">
            Update
        </button>
        <button class="btn btn-primary" formaction="/customer/${customer.customerId}/delete"
                formmethod="post">
            Delete
        </button>
        <button class="btn btn-primary" formaction="/customer/all" formmethod="get">
            Show all
        </button>
        <%--<button formaction="/customer/${customer.customerId}/delete" formmethod="post">--%>
        <%--Delete--%>
        <%--</button><br>--%>
        <%--<button formaction="/customer/all" formmethod="get">--%>
        <%--Show all--%>
        <%--</button>--%>
        <%--</div>--%>
    </form>
</div>
</body>
</html>
