<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View"/>
</c:import>
<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#"/>
	</c:import>
	<div class="main-content">
		<!-- Container for Sorting Choices
         Each link should take the user to this current page and use any combination of the following
         querystring parameters to sort the page:
            - sortOrder (string) - PriceLowToHigh,PriceHighToLow,RatingHighToLow
        -->
		<div id="sorting-options">
			<h3>Sort By</h3>
			<ul>
				<li><a href="?sortOrder=PriceLowToHigh">Price - Low to High</a></li>
				<li><a href="?sortOrder=PriceHighToLow">Price - High to Low</a></li>
				<li><a href="?sortOrder=RatingHighToLow">Rating - High to Low</a></li>
			</ul>
		</div>
		<!-- Container for all of the Products -->
		<!-- The list of products is available using the `products` variable -->
		<div id="grid">
			<!--
            The following HTML shows different examples of what HTML could be rendered based on different rules.
            For purposes of demonstration we've written it out so you can see it when you load the page up.
            -->
			<!-- Standard Product -->
			<c:forEach var="product" items="${products}">
			<c:choose>
			<c:when test="${product.remainingStock==0}">
			<div class="tile sold-out">
				<span class="banner">Sold Out</span>
				</c:when>
				<c:when test="${product.topSeller}">
				<div class="tile ">
					<span class="banner top-seller">Top Seller!</span>
					</c:when>
					<c:otherwise>
					<div class="tile ">
						</c:otherwise>
						</c:choose>
						<a class="product-image" href="<c:url value="/products/detail?id=${product.id}"/>">
							<img src="<c:url value="/images/product-images/${product.imageName}" />"/>
						</a>
						<div class="details">
							<p class="name">${product.name}</p>
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
									<span>&#9734;</span>
								</c:if>
							</div>
							<c:if test="${product.remainingStock<=5 && product.remainingStock>0}">
								<span class="product-alert">Only ${product.remainingStock} left!</span>
							</c:if>
							<p class="price">${product.price}</p>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>