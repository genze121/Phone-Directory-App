<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<%@include file="all_Component/allComponent.jsp"%>
</head>
<body
	style="background-color: #bd4f6c; background-image: linear-gradient(326deg, #bd4f6c 0%, #d7816a 74%);">
	<%@include file="all_Component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-2">
					<div class="card-header text-center mt-2 pt-3 register-form">
						<i class='fa fa-user-plus'></i> Registration Form

						<%
							String SuccessMssg = (String) session.getAttribute("SuccessMssg");
							String ErrorMssg = (String) session.getAttribute("ErrorMssg");

							if (SuccessMssg != null) {
						%>
						<div class="alert alert-success" role="alert">
							<%=SuccessMssg%> For Login Click Here <a href="login.jsp"> Login </a>
						</div>

						<%
							session.removeAttribute("SuccessMssg");
							}

							if (ErrorMssg != null) {
						%>
						<div class="alert alert-danger" role="alert">
							<%=ErrorMssg%>
						</div>
						<%
							session.removeAttribute("ErrorMssg");
							}
						%>

					</div>
					<div class="card-body">

						<form action="register" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">First Name</label> <input
									type="text" name="first_name" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter the First Name">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Last Name</label> <input
									type="text" name="last_name" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter the Last Name">
							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email_" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="password_" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<button type="submit"
								class="btn badge-pill btn-block btn-primary">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="all_Component/footer.jsp"%>
</body>
</html>