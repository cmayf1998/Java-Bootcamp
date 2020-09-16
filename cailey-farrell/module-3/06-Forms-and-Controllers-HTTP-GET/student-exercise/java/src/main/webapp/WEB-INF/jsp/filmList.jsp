<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/searchFilms"/>
<form method="GET" action="${formAction}">
    <div class="formInputGroup">
        <label for="minLength">Minimum Length:</label>
        <input type="text" name="minLength" id="minLength"/> <!--has to match the name of argument-->
    </div>
    <div class="FormInputGroup">
        <label for="maxLength">Maximum Length</label>
        <input type="text" name="maxLength" id="maxLength">
    </div>
    <div class="formInputGroup">
    <label for="category">Genre:</label>
        <select name="category" id="category">
        <option value="Children">Children</option>
            <option value="Comedy">Comedy</option>
            <option value="Drama">Drama</option>
        </select>
    </div>
    <input class="formSubmitButton" type="submit" value="Submit"/>
</form>
<table class="table">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Release</th>
        <th>Length</th>
        <th>Rating</th>
    </tr>
    <c:forEach items="${films}" var="film">
        <tr>
            <!-- What do we print here for each actor? -->
            <td>${film.title}</td>
            <td> ${film.description}</td>
            <td> ${film.release}</td>
            <td> ${film.length}</td>
            <td> ${film.rating}</td>

        </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>