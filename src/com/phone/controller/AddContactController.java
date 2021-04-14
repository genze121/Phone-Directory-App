package com.phone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phone.entity.ContactDetails;
import com.phone.model.ContactDAO;

/**
 * Servlet implementation class AddContactController
 */
@WebServlet("/addContact")
public class AddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ContactDAO contactDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContactController() {
		super();
		contactDAO=new ContactDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userid"));
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String email = request.getParameter("email_");
		String mobileno = request.getParameter("mobile_no");
		String about = request.getParameter("about");
		
		ContactDetails contact=new ContactDetails(firstname, lastname, email, mobileno, about,userId);
		
		boolean finalAdd=contactDAO.saveContact(contact);
		HttpSession session=request.getSession();
		if(finalAdd) {
			System.out.println("CONTACT DETAILS IS AVAILABLE:- " + contact);
			session.setAttribute("SuccessMssg", "Contact added successfully.....");
			response.sendRedirect("addContact.jsp");
		}
		else {
			System.out.println("CONTACT DETAILS IS NOT AVAILABLE:- " + contact);
			session.setAttribute("ErrorMssg", "Something went wrong on the server.Please try again.....");
			response.sendRedirect("addContact.jsp");
		}

	}

}
