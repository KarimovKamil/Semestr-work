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
    <title>Customer</title>
</head>
<body>
    Id: ${customer.customerId}<br>
    Last name: ${customer.lastName}<br>
    First name: ${customer.firstName}<br>
    Middle name: ${customer.middleName}<br>
    Phone: ${customer.phoneNumber}<br>
    Passport: ${customer.passport}<br>
    Date of birth: ${customer.dateOfBirth}<br>
    <form>
        <button formaction="/customer/${customer.customerId}/delete" formmethod="post">
            Delete
        </button><br>
        <button formaction="/customer/all" formmethod="get">
            Show all
        </button>
    </form>
</body>
</html>
