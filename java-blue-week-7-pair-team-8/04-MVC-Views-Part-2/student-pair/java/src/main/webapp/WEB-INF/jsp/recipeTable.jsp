<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Recipe Table View</title>
    <link rel="stylesheet" href="css/site.css" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
            <li><a href="recipeTiles">Tile Layout</a></li>
            <li><a href="recipeTable">Table Layout</a></li>
        </ul>
        
    </nav>
    <section id="main-content">

       <!-- Use the request attribute "recipes" (List<Recipe>) -->

        <ul>
            <li>Name</li>
            <li>Type</li>
            <li>Cook Time</li>
            <li>Ingredients</li>
            <li>Rating</li>
        </ul>

        <c:forEach var="recipe" items="${recipes}">
        <table class="table">
            <tr>${recipe.name}</tr>
            <tr>${recipe.recipeType}</tr>
            <tr>${recipe.cookTimeInMinutes}</tr>
            <tr>${recipe.ingredients.size()}</tr>
            <tr> <img src="<c:url value="/img/recipe${recipe.recipeId}.jpg"/>"/> </tr>
            <tr> <img src="<c:url value="/img/${Math.round(recipe.averageRating)}-star.png"/>"/> </tr>
        </table>
         </c:forEach>

    </section>
</body>
</html>