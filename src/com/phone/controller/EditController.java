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
 * Servlet implementation class EditController
 */
@WebServlet("/update")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContactDAO contactDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditController() {
		super();
		contactDAO = new ContactDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cid = Integer.parseInt(request.getParameter("cid"));
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String email = request.getParameter("email_");
		String mobileno = request.getParameter("mobile_no");
		String about = request.getParameter("about");
		int userid=Integer.parseInt(request.getParameter("userid"));

		ContactDetails contact = new ContactDetails();
		contact.setId(cid);
		contact.setFirstname(firstname);
		contact.setLastname(lastname);
		contact.setUsername(email);
		contact.setMobileNo(mobileno);
		contact.setAbout(about);
		contact.setUserId(userid);

		boolean finalUpdated = contactDAO.updateContact(contact);

		HttpSession session = request.getSession();
		if (finalUpdated) {
			System.out.println("CONTACT DETAILS IS AVAILABLE:- " + contact);
			session.setAttribute("SuccessMessage", "Contact updated successfully.....");
			response.sendRedirect("viewContact.jsp");
		} else {
			System.out.println("CONTACT DETAILS IS NOT AVAILABLE:- " + contact);
			session.setAttribute("ErrorMessage", "Something went wrong on the server.Please try again.....");
			response.sendRedirect("editContact.jsp?cid=" + cid);
		}

	}

}
