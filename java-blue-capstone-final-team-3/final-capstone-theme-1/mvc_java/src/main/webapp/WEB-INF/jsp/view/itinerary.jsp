<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!-- Begin Page Content -->


<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Your Itineraries</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <a href="/itineraryForm" class="btn btn-success btn-icon-split btn-sm">
                    <span class="icon text-white-50">
                      <i class="fas fa-check"></i>
                    </span>
                <span class="text">Create Itinerary</span>
            </a>
        </div>
        <div class="card-body">
            <div class="table-responsive">

                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Itinerary Name</th>
                        <th>Starting Point</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Add Landmark</th>
                        <th>Itinerary Destinations</th>
                        <th>Travel Route</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="itinerary" items="${itineraries}">
                        <tr>
                            <td><a>${itinerary.itineraryName}</a></td>
                            <td>${itinerary.startingPoint}</td>
                            <td>${itinerary.startDate}</td>
                            <td>${itinerary.endDate}</td>
                            <td>
                                <input name="itineraryId" type="hidden" value="${itinerary.itineraryId}">
                                <a href="/user/addLandmark?itineraryId=${itinerary.itineraryId}" class="btn btn-secondary btn-sm">
                                    <span class="text">Add Landmarks</span>
                                </a>
                            </td>
                            <td>

                                <input name="itineraryId" type="hidden" value="${itinerary.itineraryId}">
                                <a href="/showItineraryDestinations?itineraryId=${itinerary.itineraryId}">
                                            <img class="img-itinerary-icons rounded-circle" src="/img/travel-route.png">
                                </a>
                            </td>
                            <td>
                                <input name="itineraryId" type="hidden" value="${itinerary.itineraryId}">
                                <a href="/showTravelRoute?itineraryId=${itinerary.itineraryId}">
                                    <img class="img-itinerary-icons rounded-circle" src="/img/map-icon.png">
                                </a>
                            </td>
                            <td>
                                <input name="itineraryId" type="hidden" value="${itinerary.itineraryId}">
                                    <a href="/itineraryForm?itineraryId=${itinerary.itineraryId}">
                                            <img class="img-itinerary-icons rounded-circle" src="/img/edit-icon.png">
                                    </a>
                            </td>
                            <td>
                                <form action="/deleteItinerary" method="post">
                                    <input name="itineraryId" type="hidden" value="${itinerary.itineraryId}">
                                <button class="img-itinerary-icons rounded-circle" type="submit" >
                                        <img class="img-itinerary-icons rounded-circle" src="/img/delete-icon.png">
                                </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="/js/basictable.js"></script>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />