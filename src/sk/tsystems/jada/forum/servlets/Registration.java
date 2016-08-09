package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.PersonService;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String fullname = request.getParameter("fullName");
		String email = request.getParameter("Email");
		String password = request.getParameter("Password");
		Date birthDate = null;
		try {
			String birthDateString = request.getParameter("birthDate");
			birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int hashedPass= new PersonService().hashPassword(password);
		Person person = new Person(userName, hashedPass, fullname, email, birthDate);
		new PersonService().registerPerson(person);
		request.getSession().setAttribute("user", person);
		response.sendRedirect("/JADA_Tsystems_TeamProject/forum");

	}

}
