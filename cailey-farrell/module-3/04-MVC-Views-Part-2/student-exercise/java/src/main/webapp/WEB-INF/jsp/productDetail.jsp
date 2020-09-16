<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

<!-- Container for the Product -->
<!-- The current product is available using the `product` variable -->

<div id="product-detail">
	<img src="<c:url value="/images/product-images/${product.imageName}" />"/>
	<div clas="product-description">
		<h3>${product.name}</h3>

	<!-- .filled will make the star solid -->
		<div class="rating">
			<c:if test="${product.averageRating >= 1 && product.averageRating < 2}">
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span> </c:if>
			<c:if test="${product.averageRating >= 2 && product.averageRating < 3}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span></c:if>
			<c:if test="${product.averageRating >= 3 && product.averageRating < 4}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span>
				<span>&#9734;</span></c:if>
			<c:if test="${product.averageRating >= 4 && product.averageRating < 5}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span></c:if>
			<c:if test="${product.averageRating >= 5}">
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span class="filled">&#9734;</span>
				<span>&#9734;</span></c:if>
		</div>
		<c:if test="${product.remainingStock > 0 && product.remainingStock <= 5}">
			<span class="alert-remaining">BUY NOW! Only ${product.remainingStock} left!</span>

			<!-- Include this if the product has a Remaining Stock of 5 or less -->
		</c:if>

		<p class="description">${product.description}</p>
		<p class="price">${product.price}</p>

		<!-- If item is in stock -->
		<c:if test="${product.remainingStock > 1}">
			<button class="action">Add to Cart</button>

		</c:if>

		<c:if test="${product.remainingStock == 0}">
			<button disabled>Sold Out</button>
		</c:if>

	</div>
</div>

		<!--<button disabled>Sold Out</button>-->

<c:import url="/WEB-INF/jsp/common/footer.jsp" />