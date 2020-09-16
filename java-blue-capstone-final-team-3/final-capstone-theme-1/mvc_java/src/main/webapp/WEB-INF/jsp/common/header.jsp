<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="Team Capstone Columbus Tech Start">

	<title>Capstone Project - Dashboard</title>

	<!-- Custom fonts for this template-->
	<link href="../../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css"/>
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="../../../css/sb-admin-2.min.css" rel="stylesheet"/>
	<link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet"/>

	<!-- Custom styles for this project-->
	<link href="../../../css/site.css" rel="stylesheet"/>
	<link href="../../../css/custom.css" rel="stylesheet"/>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

	<!-- Sidebar -->
	<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
		<!-- Sidebar - Brand -->
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
			<div class="sidebar-brand-icon">
				<c:url var="logoImageUrl" value="/img/city-logo2.jpg" />
				<img class="rounded-circle" src="${logoImageUrl}" />
			</div>
			<div class="sidebar-brand-text mx-3">City Tours</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Divider -->
		<hr class="sidebar-divider">

		<div class="text-center sidebar-heading">
			Account Access
		</div>

		<!-- Login / Register -->

		<li class="text-center nav-item">
			<a class="text-center nav-link" href="/login">
				<span>Login</span></a>
		</li>

		<li class="text-center nav-item">
			<a class="text-center nav-link" href="/register">
				<span>Register</span></a>
		</li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<c:if test="${LOGGED_USER.userName != null}">
		<div class="text-center sidebar-heading">
			Itinerary Builder
		</div>
		</c:if>

		<!-- Nav Item - Tables -->
		<li class="text-center nav-item">
			<a class="text-center nav-link" href="/user/landmarks">
				<span>Search Landmarks</span></a>
		</li>

		<c:if test="${LOGGED_USER.userName != null}">
		<li class="text-center nav-item">
			<a class="text-center nav-link" href="/user/itinerary">
				<span>Itinerary</span></a>
		</li>
		</c:if>

		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">


	</ul>
	<!-- End of Sidebar -->

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<!-- Topbar -->
			<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

				<!-- Sidebar Toggle (Topbar) -->
				<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
					<i class="fa fa-bars"></i>
				</button>

				<!-- Topbar Navbar -->
				<ul class="navbar-nav ml-auto">

					<div class="topbar-divider d-none d-sm-block"></div>

					<!-- Nav Item - User Information -->
					<li class="nav-item dropdown no-arrow">
						<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="mr-2 d-none d-lg-inline text-gray-600 small">${LOGGED_USER.userName}</span>
							<img class="img-profile rounded-circle" src="/img/default-user.png">
						</a>
						<!-- Dropdown - User Information -->
						<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">

<%--							<c:if test="${LOGGED_USER.userName = null}"> {--%>

<%--							<a class="dropdown-item" href="/login">--%>
<%--								<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>--%>
<%--								Profile--%>
<%--							</a> }--%>
<%--								else { <a class="dropdown-item" href="/profile">--%>
<%--									<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>--%>
<%--									Profile--%>
<%--								</a> }--%>
<%--							</c:if>--%>

							<c:choose>
								<c:when test="${LOGGED_USER.userName != null}">
								<a class="dropdown-item" href="/profilePage">
									<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
									Profile
								</a>
									<br />
								</c:when>
								<c:otherwise>
									<a class="dropdown-item" href="/login">
										<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
										Profile
									</a>
									<br />
								</c:otherwise>
							</c:choose>



							<c:if test="${LOGGED_USER.userName != null}">
								<div class="dropdown-divider"></div>

							<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
								<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
								Logout
							</a>
							</c:if>

						</div>
					</li>

				</ul>

			</nav>
			<!-- End of Topbar -->
