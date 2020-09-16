<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-4 text-gray-800">Landmark Details</h1>

            <div>

                <div>
                    <h3>${landmark.landmarkName}</h3>
                    <!-- .filled will make the star solid -->

                    <p>Address:
                    <ul>
                        <li> ${landmark.address} </li>
                    </ul>
                    </p>

                    <p>Description:
                    <ul>
                        <li> ${landmark.description} </li>
                    </ul>
                    </p>

                    <p>Available Days/Hours:
                    <ul>
                        <li> Days: ${landmark.dayOpen} - ${landmark.dayClose} </li>
                        <li> Hours: ${landmark.openingTime} - ${landmark.closingTime}</li>
                    </ul>
                    </p>

                    <p>Venue Type:
                    <ul>
                        <li> ${landmark.venueType} </li>
                    </ul>
                    </p>

                    <img class="w-50 p-3" src="<c:url value="/img/landmarks/${landmark.imageUrl}" />"/>


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