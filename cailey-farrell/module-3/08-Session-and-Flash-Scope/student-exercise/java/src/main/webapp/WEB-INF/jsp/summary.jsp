<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle">New Checking Account Application</c:param>
</c:import>

<h2>New Checking Account Application</h2>
<h3>Summary</h3>

<div class='summaryBlock'>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Favorite Color</span>:
		<c:out value="${favorites.color}" />
	</div>
	<div class='summaryElement'>
		<span class='summaryElementHeader'>Favorite Food</span>:
		<c:out value="${favorites.food}" />
	</div>

	<div class='summaryElement'>
		<span class='summaryElementHeader'>Favorite Season</span>:
		<c:out value="${favorites.season}" />
	</div>

	</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />