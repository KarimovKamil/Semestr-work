<%--
  Created by IntelliJ IDEA.
  User: Manymuch
  Date: 14.12.2016
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goods</title>
</head>
<body>
    Id: ${good.goodsId}<br>
    Type: ${good.goodsType}<br>
    Price: ${good.goodsPrice}<br>
    <form>
        <button formaction="/goods/${good.goodsId}/delete" formmethod="post">
            Delete
        </button><br>
        <button formaction="/goods/all" formmethod="get">
            Show all
        </button>
    </form>
</body>
</html>
