<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!-- Begin Page Content -->


<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Add Landmark</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Select the landmark to add to your itinerary</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">

                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Add</th>
                        <th>Landmark Name</th>
                        <th>Venue Type</th>
                        <th>Description</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="landmark" items="${landmarks}">
                        <tr>
                            <td>
                                <input name="landmarkId" type="hidden" value="${landmark.landmarkId}">

                                <c:url var="addLandmark" value="/user/addLandmarkToItinerary">
                                    <c:param name="itineraryId"  value="${itineraryId}" />
                                    <c:param name="landmarkId"    value="${landmark.landmarkId}" />
                                </c:url>

                                <a href="${addLandmark}">
                                    <button class="btn btn-success btn-block btn-sm"> Add </button>
                                </a>
                            </td>
                            <td><a href="/user/landmarks/details?id=${landmark.landmarkId}">${landmark.landmarkName}</a></td>
                            <td>${landmark.venueType}</td>
                            <td>${landmark.description}</td>



                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->
<!-- End of Page Content -->

<!-- Page level plugins -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="/js/basictable.js"></script>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
