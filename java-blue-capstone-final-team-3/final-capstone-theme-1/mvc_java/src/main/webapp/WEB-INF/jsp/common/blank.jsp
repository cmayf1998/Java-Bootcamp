<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">Landmark Details</h1>

            <div>

                <div>
                    <h3>Parq Casino</h3>
                    <!-- .filled will make the star solid -->

                    <p>Description:
                    <ul>
                        <li> Plush riverside resort offering upscale dining, an indoor pool & a spa, plus a casino. </li>
                    </ul>
                    </p>

                    <p>Available Days/Hours:
                    <ul>
                        <li> Monday 9:00AM - 3:00AM </li>
                        <li> Tuesday 9:00AM - 3:00AM </li>
                        <li> Wednesday 9:00AM - 3:00AM </li>
                        <li> Thursday 9:00AM - 3:00AM </li>
                        <li> Friday 9:00AM - 3:00AM </li>
                        <li> Saturday 9:00AM - 3:00AM </li>
                        <li> Sunday 9:00AM - 3:00AM </li>
                    </ul>
                    </p>

                    <p>Venue Type:
                    <ul>
                        <li> Entertainment </li>
                    </ul>
                    </p>

                    <img class="w-50 p-3" src="<c:url value="/img/landmarks/parqcasino.parqCasino.jpg" />"/>


<%--                re use as add itinerary button --%>
                    <c:if test="${LOGGED_USER.userName != null}">
                        <button> Add Itinerary </button>
                    </c:if>

<%--                    create like and dislike button--%>
<%--                    <c:if test="${product.remainingStock == 0}">--%>
<%--                        <button disabled>Sold Out</button>--%>
<%--                    </c:if>--%>

                </div>

            </div>

        </div>
        <!-- /.container-fluid -->
        <!-- End of Main Content -->


<c:import url="/WEB-INF/jsp/common/footer.jsp" />