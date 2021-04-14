<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.phone.entity.UserDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="allComponent.jsp"%>
<title>Phone Directory App</title>
</head>
<body>

	<nav
		class="navbar navbar-expand-lg navbar-light bg-warning navbar-custom">
		<a class="navbar-brand" href="index.jsp"><i
			class='fa fa-phone-square'></i> Phone Directory App</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp"><i class='fa fa-home'></i> Home <span
						class="sr-only">(current)</span> </a></li>
				<li class="nav-item active"><a class="nav-link"
					href="addContact.jsp"><i class='fa fa-plus-square'></i> Add
						Contact No</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="viewContact.jsp"><i class='fa fa-eye'></i> View Contact</a></li>
			</ul>
			<%
				UserDetails user = (UserDetails) session.getAttribute("user");
				if (user == null) {
			%>
			<form class="form-inline my-2 my-lg-0 form-custom">
				<a href="login.jsp" class="btn btn-success btn-lg"> <i
					class='fa fa-user-circle-o'></i> Login
				</a> <a href="register.jsp" class="btn btn-danger btn-lg  ml-2"><i
					class='fa fa-user-plus'></i> Register </a>
			</form>
			<%
				}

				else {
			%>

			<form class="form-inline my-2 my-lg-0 form-custom">
				<button class="btn btn-success btn-lg"><%=user.getFirstname() + " " + user.getLastname()%></button>
				<button type="button" class="btn btn-danger btn-lg  ml-2" data-toggle="modal"
					data-target="#exampleModal"> <i class='fa fa-power-off'></i>
					Logout
				</button>
			</form>
			<%
				}
			%>

		</div>

		<!-- Logout Popup -->

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-success head-size" id="exampleModalLabel"> <u>Logout Modal</u> </h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
					
					<h2 class="text-center text-danger size-grow"> Do you want to Logout? </h2>
					
					</div>
					<div class="text-center">
						<button type="button" class="btn btn-secondary btn-lg"
							data-dismiss="modal">Close</button>
						<a href="logout" type="button" class="btn btn-primary btn-lg">Logout</a>

					</div>

					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<!-- End of Logout Popup -->
	</nav>
</body>
</html>