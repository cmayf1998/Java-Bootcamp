<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>
<c:url var="formAction" value="/searchCustomers"/>
<form method="POST" action="${formAction}">
    <div class="FormInputGroup">
        <label for="searchName">Name</label>
        <input type="text" name="searchName" id="searchName">
    </div>
    <div class="formInputGroup">
        <label for="sortOrder">Sort:</label>
        <select name="sortOrder" id="sortOrder">
            <option value="last_name">Last Name</option>
            <option value="first_name">First Name</option>
            <option value="email">Email</option>
    <option value="active">Active</option>
        </select>
    </div>
    <input class="formSubmitButton" type="submit" value="Submit"/>
</form>
<table class="table">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Active</th>
    </tr>
    <c:forEach items="${customers}" var="customer">
    <tr>
        <td>${customer.firstName} ${customer.lastName}</td>
        <td>${customer.email}</td>
        <td>${customer.active}</td>
    </tr>
    </c:forEach>
</table>

<%@include file="common/footer.jspf"%>