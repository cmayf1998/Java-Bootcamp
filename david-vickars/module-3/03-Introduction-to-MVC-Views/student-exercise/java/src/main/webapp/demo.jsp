<%--
  Created by IntelliJ IDEA.
  User: Chase Java
  Date: 8/5/2020
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>>
    <head>
        <title>Demo Table</title>
</head>
<body>
<table border="1">
    <c:forEach begin="1" end="5" var="value">
        <tr>
            <td>${value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
