<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Favorite Season" />
</c:import>

<form method="POST">
<%--	<label>What is your favorite season?</label>--%>
<%--	<input type="text" name="favoriteSeason">--%>
<%--	--%>

	<div id="favoriteSeason">
	<input type="radio" name="favoriteSeason" value="Spring">
	<label for="favoriteSeason">Spring</label><br>
	<input type="radio" name="favoriteSeason" value="Summer">
	<label for="favoriteSeason">Summer</label><br>
	<input type="radio" name="favoriteSeason" value="Fall">
	<label for="favoriteSeason">Fall</label><br>
	<input type="radio" name="favoriteSeason" value="Winter">
	<label for="favoriteSeason">Winter</label>
	</div>
	<button type="submit">Next >>></button>
</form>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />