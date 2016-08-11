package sk.tsystems.jada.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.PersonService;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/userProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/userProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		Person editedPerson = new Person();

		Person updatePerson = (Person) request.getSession().getAttribute("user");
		System.out.println(updatePerson.toString());
		if (!updatePerson.getEmail().equals(email)) {
			editedPerson.setEmail(email);
				}
		if (!updatePerson.getFullName().equals(fullName)) {
			editedPerson.setFullName(fullName);
		}
		new PersonService().updatePersonProfile(updatePerson, editedPerson);
		request.getRequestDispatcher("/WEB-INF/jsp/userProfile.jsp").forward(request, response);
	}

}
