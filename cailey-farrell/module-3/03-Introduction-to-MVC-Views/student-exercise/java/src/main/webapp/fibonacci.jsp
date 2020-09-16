<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="Fibonacci"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fibonacciRoute" value="fibonacci.jsp">
			<c:param value="${ numberOfItems }" name="max" />
		</c:url>
		<li>
			<a href="<c:out value="${ fibonacciRoute }" />"><c:out value="${ numberOfItems }" /></a>
		</li>
	</ul>
</nav>

<!DOCTYPE html>
<html>
<body>
<ul id="fibonacci">
	<c:set var="fibonacci" value="0" />
	<c:set var="a" value="0" />
	<c:set var="b" value="1" />
	<c:forEach begin="1" end="${param.max}" var="number">
		<c:set var="fibonacci" value="${a+b}"/>
		<c:if test = "${fibonacci <= param.max && fibonacci >= 0}">
			<li>${fibonacci}</li>
		</c:if>
		<c:set var="a" value="${b}"/>
		<c:set var="b" value="${fibonacci}"/>
	</c:forEach>
</ul>
</body>
</html>


<c:import url="common/footer.jsp"></c:import>