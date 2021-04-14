package com.phone.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.entity.UserDetails;
import com.phone.model.RegisterDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterDAO registerDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		registerDAO = new RegisterDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Accepting the User Information from the Front-End

		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String username = request.getParameter("email_");
		String password = request.getParameter("password_");

		UserDetails user = new UserDetails(firstname, lastname, username, password);

		boolean finalRegister = registerDAO.registerUser(user);
		HttpSession session = request.getSession();
		if (finalRegister) {
			System.out.println("User Registration is available:- " + user);
			session.setAttribute("SuccessMssg", "Registered Successfully....");
			response.sendRedirect("register.jsp");
		} else {
			System.out.println("User Registration not available:- " + user);
			session.setAttribute("ErrorMssg", "Something went wrong.Please try again....");
			response.sendRedirect("register.jsp");
		}

	}

}
