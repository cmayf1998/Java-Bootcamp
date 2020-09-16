<%--
  Created by IntelliJ IDEA.
  User: Chase Java
  Date: 8/10/2020
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
    <H2>Alien Weight Result</H2>
    <c:url value="/img/${fn:toLowerCase(planetName)}.jpg" var="planetSrc" />
    <img src="${planetSrc}" alt="Image of ${planetName}" />
    <p>
        Your Earth Weight is ${earthWeight}, so you are ${alienWeight} on ${planetName}.
    </p>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
