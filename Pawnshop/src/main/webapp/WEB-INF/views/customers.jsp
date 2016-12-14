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
    <title>Customers</title>
</head>
<body>
    <table>
        <tr>
            <th>Id</th>
            <th>Last name</th>
            <th>First name</th>
            <th>Middle name</th>
            <th>Phone number</th>
            <th>Passport</th>
            <th>Date of birth</th>
        </tr>
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
</body>
</html>
