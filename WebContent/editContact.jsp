<%@page import="com.phone.entity.ContactDetails"%>
<%@page import="com.phone.model.ContactDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact Page</title>
<%@include file="all_Component/allComponent.jsp"%>

</head>
<body
	style="background-color: #d7d7d7; background-image: linear-gradient(147deg, #d7d7d7 0%, #353535 74%);">
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
						<i class="fa fa-edit fa-1x"></i> Edit Contact Model
					</div>
					<div class="card-body">

						<form action="update" method="post">

							<%
								int cid = Integer.parseInt(request.getParameter("cid"));
								ContactDAO contact = new ContactDAO();
								ContactDetails details = contact.getContactById(cid);
							%>
							<input type="hidden" value="<%=cid%>" name="cid">

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
									value="<%=details.getFirstname()%>" id="exampleInputFirstName1"
									placeholder="Enter the First Name">
							</div>

							<div class="form-group">
								<label for="exampleInputLastName1">Last Name</label> <input
									type="text" name="last_name" class="form-control"
									value="<%=details.getLastname()%>" id="exampleInputLastName1"
									placeholder="Enter the Last Name">
							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email_" class="form-control"
									value="<%=details.getUsername()%>" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
							</div>
							<div class="form-group">
								<label for="exampleMobileNo1">Mobile Number</label> <input
									type="text" name="mobile_no" class="form-control"
									value="<%=details.getMobileNo()%>" id="exampleMobileNo1"
									placeholder="Password">
							</div>

							<div class="form-group">
								<label for="exampleFormControlTextarea1"> About </label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									name="about" placeholder="Enter About..." rows="2"><%=details.getAbout()%></textarea>
							</div>

							<button type="submit"
								class="btn badge-pill btn-block btn-success">Save
								Contact</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="all_Component/footer.jsp"%>
</body>
</html>