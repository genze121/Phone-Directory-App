<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>Login Page</title>
</head>
<body
	style="background-color: #dfa375; background-image: linear-gradient(315deg, #dfa375 0%, #c58e7f 74%);">
	<%@include file="all_Component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-2">
					<div class="card-header text-center mt-2 pt-3 register-form">
						<i class='fa fa-user'></i> Login Form

						<%
							String ErrorMssg = (String) session.getAttribute("ErrorMssg");

							if (ErrorMssg != null) {
						%>
						<div class="alert alert-danger" role="alert">
							<%=ErrorMssg%>
						</div>
						<%
							session.removeAttribute("ErrorMssg");
							}
						%>

						<%
							String logoutMssg = (String) session.getAttribute("logoutMssg");

								if (logoutMssg != null) {
						%>
						<div class="alert alert-success" role="alert">
							<%=logoutMssg%>
						</div>
						<%
							session.removeAttribute("logoutMssg");
							}
						%>


					</div>
					<div class="card-body">

						<form action="login" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email_" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">
							</div>
							<div class="form-group mt-4">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="password_" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<button type="submit"
								class="btn badge-pill btn-block btn-success mt-5">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


	<%@include file="all_Component/footer.jsp"%>

</body>
</html>