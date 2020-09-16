<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>

	</head>
	<body>
		<h1>Welcome to our reviews!</h1>
		<p><a href="reviewInput">Add a review</a> </p>
	<table class="table">
		<tr>
			<th>Username</th>
			<th>Rating</th>
			<th>Title</th>
			<th>Date Submitted</th>
			<th>Text</th>
		</tr>
		<c:forEach items="${allReviews}" var="review">
			<tr>
				<td>${review.username}</td>
				<td>${review.title} </td>
				<td>${review.rating}</td>
				<td>${review.dateSubmitted}</td>
				<td>${review.text}</td>
			</tr>
		</c:forEach>

	</table>
	</body>
</html>