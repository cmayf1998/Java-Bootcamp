<%--
  Created by IntelliJ IDEA.
  User: Chase Java
  Date: 8/10/2020
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id = "main-content">
    <H2>Alien Age</H2>
    <c:url value="/alienAgeResult" var="alienAgeResultUrl"/>
    <form action="${alienAgeResultUrl}">
        <p>
            <%--@declare id="planetname"--%><label for="planetName">Select a planet</label>
            <select name="planetName">
                <c:forEach var="planet" items="${planets}">
                    <option value="${planet.name()}">${planet.getPlanetName()}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            <%--@declare id="earthage"--%><label for="earthAge">Enter you Earth Age</label>
            <input type="text" name="earthAge"/>
        </p>
        <button>Submit</button>
    </form>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />