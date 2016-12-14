<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 14.12.2016
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goods</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Type</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${goods}" var="goods">
        <tr>
            <td><a href="/goods/${goods.goodsId}">${goods.goodsId}</a></td>
            <td>${goods.goodsType}</td>
            <td>${goods.goodsPrice}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
