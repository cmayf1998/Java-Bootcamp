<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid">
    <div class="form-container">
        <c:url var="itineraryForm" value="/itineraryForm"/>
        <form:form action="${itineraryForm}" method="POST" modelAttribute="itinerary">
            <input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}"/>
            <form:input type="hidden" name="itineraryId" value="${itineraryId}" path="itineraryId"/>
            <fieldset>
                <legend>Itinerary Form</legend>

                <div class="formgrid">
                    <form:input id="itineraryName" name="itineraryName" path="itineraryName" required="true"/>
                    <label for="itineraryName">Name</label>



                    <form:input type="date" id="startDate" name="startDate" path="startDate" required="true"/>
                    <label for="startDate">Start Date</label>

                    <form:input type="date" id="endDate" name="endDate" path="endDate" required="true"/>
                    <label for="endDate">End Date</label>

                    <button type="submit">SUBMIT</button>
                </div>
            </fieldset>
        </form:form>
    </div>
    <!-- /.form-container -->
</div>
<!-- /.container-fluid -->
<!-- End of Page Content -->

<!-- Page level plugins -->


<c:import url="/WEB-INF/jsp/common/footer.jsp" />