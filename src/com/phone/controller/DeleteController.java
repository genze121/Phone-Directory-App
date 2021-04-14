package com.phone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.model.ContactDAO;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContactDAO contactDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteController() {
		super();
		contactDAO = new ContactDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cid = Integer.parseInt(request.getParameter("cid"));

		boolean finalDelete = contactDAO.deleteContactById(cid);
		HttpSession session = request.getSession();
		if (finalDelete) {
			session.setAttribute("SuccessMessage", "Contact deleted successfully.....");
			response.sendRedirect("viewContact.jsp");
		} else {
			session.setAttribute("ErrorMessage", "Something went wrong on the server.Please try again.....");
			response.sendRedirect("viewContact.jsp");
		}
	}

}
