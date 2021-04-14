<%@page import="com.phone.entity.ContactDetails"%>
<%@page import="com.phone.model.ContactDAO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>View Contact Page</title>

<style type="text/css">
.test-format {
	font-family: galindo;
}

.test-format:hover {
	background-color: #f4f4e6;
	cursor: pointer;
}
</style>
</head>
<body
	style="background-color: #a44a2a; background-image: linear-gradient(315deg, #a44a2a 0%, #cd8a66 74%);">

	<%@include file="all_Component/navbar.jsp"%>

	<%
		if (user == null) {
			session.setAttribute("ErrorMssg", "Please login to view the contact details....");
			response.sendRedirect("login.jsp");
		}
	%>

	<%
		String SuccessMessage = (String) session.getAttribute("SuccessMessage");
		String ErrorMessage = (String) session.getAttribute("ErrorMessage");

		if (SuccessMessage != null) {
	%>
	<div class="alert alert-success" role="alert">
		<%=SuccessMessage%>
	</div>

	<%
		session.removeAttribute("SuccessMessage");
		}

		if (ErrorMessage != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=ErrorMessage%>
	</div>

	<%
		session.removeAttribute("ErrorMessage");
		}
	%>

	<div class="container-fluid">
		<div class="row p-2">
			<%
				if (user != null) {
					ContactDAO contact = new ContactDAO();
					List<ContactDetails> lists = contact.getAllContactDetails(user.getId());

					for (ContactDetails details : lists) {
			%>
			<div class="col-md-3">
				<div class="card mt-3 test-format">
					<div class="card-body">

						<h4>
							First Name:-
							<%=details.getFirstname()%></h4>
						<h4>
							Last Name:-
							<%=details.getLastname()%></h4>
						<h4>
							Email:-
							<%=details.getUsername()%></h4>
						<h4>
							Mobile No:-
							<%=details.getMobileNo()%></h4>
						<h4>
							About:-
							<%=details.getAbout()%></h4>
						<div class="text-center mt-2">
							<a href="editContact.jsp?cid=<%=details.getId()%>"
								class="btn btn-info"> Edit</a> 
								<a href="delete?cid=<%=details.getId() %>" class="btn btn-danger"> Delete</a>
						</div>
					</div>
				</div>

			</div>
			<%
				}
				}
			%>

		</div>
	</div>

	<%@include file="all_Component/footer.jsp"%>

</body>
</html>