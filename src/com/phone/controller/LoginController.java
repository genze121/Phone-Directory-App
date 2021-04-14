package com.phone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.entity.UserDetails;
import com.phone.model.LoginDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDAO loginDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		loginDAO = new LoginDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email_");
		String password = request.getParameter("password_");

		UserDetails user = loginDAO.loginUser(username, password);
		HttpSession session = request.getSession();
		if (user != null) {
			System.out.println("LOGIN INFO for user availability:- " + user);
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("LOGIN INFO for user not availability:- " + user);
			session.setAttribute("ErrorMssg", "Username and Password is incorrect.....");
			response.sendRedirect("login.jsp");
		}
	}

}
