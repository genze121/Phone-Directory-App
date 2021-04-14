<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>Add Contact Page</title>
</head>
<body
	style="background-color: #fdb813; background-image: linear-gradient(315deg, #fdb813 0%, #788cb6 74%);">
	<%@include file="all_Component/navbar.jsp"%>

	<%
		if (user == null) {
			session.setAttribute("ErrorMssg", "Please login to add the contact details....");
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center mt-2 pt-3 register-form">
						<i class="fa fa-plus-square"></i> Add Contact Model

						<%
							String SuccessMssg = (String) session.getAttribute("SuccessMssg");
							String ErrorMessg = (String) session.getAttribute("ErrorMssg");

							if (SuccessMssg != null) {
						%>
						<div class="alert alert-success" role="alert">
							<%=SuccessMssg%>
							View contacts here <a href="viewContact.jsp"> View Contacts </a>
						</div>
						<%
							session.removeAttribute("SuccessMssg");
							}

							if (ErrorMessg != null) {
						%>

						<div class="alert alert-danger">
							<%=ErrorMessg%>
						</div>
						<%
							session.removeAttribute("ErrorMessg");
							}
						%>
					</div>
					<div class="card-body">

						<form action="addContact" method="post">

							<%
								if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userid">
							<%
								}
							%>
							<div class="form-group">
								<label for="exampleInputFirstName1">First Name</label> <input
									type="text" name="first_name" class="form-control"
									id="exampleInputFirstName1" placeholder="Enter the First Name">
							</div>

							<div class="form-group">
								<label for="exampleInputLastName1">Last Name</label> <input
									type="text" name="last_name" class="form-control"
									id="exampleInputLastName1" placeholder="Enter the Last Name">
							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email_" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">
							</div>
							<div class="form-group">
								<label for="exampleMobileNo1">Mobile Number</label> <input
									type="text" name="mobile_no" class="form-control"
									id="exampleMobileNo1" placeholder="Password">
							</div>

							<div class="form-group">
								<label for="exampleFormControlTextarea1"> About </label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									name="about" placeholder="Enter About..." rows="2"></textarea>
							</div>

							<button type="submit" class="btn badge-pill btn-block btn-dark"> Add Contact</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_Component/footer.jsp"%>
</body>
</html>