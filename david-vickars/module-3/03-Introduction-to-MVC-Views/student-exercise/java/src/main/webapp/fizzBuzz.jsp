<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="common/header.jsp">
	<c:param name="title" value="FizzBuzz"></c:param>
</c:import>

<nav id="page-options">
	<ul>
		<c:set var="numberOfItems" value="20" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="50" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>

		<c:set var="numberOfItems" value="100" />
		<c:url var="fizzBuzzRoute" value="fizzBuzz.jsp">
			<c:param value="${ numberOfItems }" name="number" />
		</c:url>
		<li><a href="<c:out value="${ fizzBuzzRoute }" />"><c:out value="${ numberOfItems }" /></a></li>
	</ul>
</nav>

<%--
	REPLACE THIS COMMENT WITH YOUR UNORDERED LIST...
 --%>
<ul id="fizzbuzz">
	<c:forEach begin="1" end="${param.number}" var="currentNumber">
		<c:choose>
			<c:when test="">
				<li class="fizzbuzz">FizzBuzz</li>
			</c:when>
			<c:when test="">
				<li class="fizz">FizzBuzz</li>
			</c:when>
			<c:when test="">
				<li class="buzz">FizzBuzz</li>
			</c:when>
			<c:otherwise>
				<li>${currentNumber}</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>

<c:import url="common/footer.jsp"></c:import>