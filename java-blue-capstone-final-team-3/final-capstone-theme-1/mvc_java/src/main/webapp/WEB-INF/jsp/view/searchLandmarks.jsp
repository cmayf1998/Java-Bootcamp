<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

        <!-- Begin Page Content -->


        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Search Landmarks</h1>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">

            <div class="card-body">
              <div class="table-responsive">

                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Landmark Name</th>
                      <th>Venue Type</th>
                      <th>Description</th>
                        <th>Like</th>
                        <th>Dislike</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="landmark" items="${landmarks}">
                        <tr>
                            <td><a href="/user/landmarks/details?id=${landmark.landmarkId}">${landmark.landmarkName}</a></td>
                            <td>${landmark.venueType}</td>
                            <td>${landmark.description}</td>
                            <td>
                                <a href="/user/landmarks/rating?id=${landmark.landmarkId}&direction=like">
                                   <button class="btn btn-success btn-circle btn-sm">${landmark.likes}</button>
                                </a>
                            </td>
                            <td>
                                <a href="/user/landmarks/rating?id=${landmark.landmarkId}&direction=dislike">
                                    <button class="btn btn-danger btn-circle btn-sm" >${landmark.dislikes}</button>
                                </a>
                            </td>
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