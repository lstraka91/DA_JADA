package sk.tsystems.jada.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.PersonService;

/**
 * Servlet implementation class UserProfile, that servlet have to show all
 * person data to the Client and if client send request to update some profile
 * info in post method are all changes implemented
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
		if (request.getSession().getAttribute("user") != null) {

			request.getRequestDispatcher("/WEB-INF/jsp/userProfile.jsp").forward(request, response);
		} else {
			response.sendRedirect("/JADA_Tsystems_TeamProject/forum");
		}
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
		String oldPass = request.getParameter("oldpass");
		String newPass = request.getParameter("password");

		if (request.getSession().getAttribute("user") != null) {

			Person updatePerson = (Person) request.getSession().getAttribute("user");
			System.out.println(updatePerson.toString());
			System.out.println(editedPerson.toString());
			System.out.println("old" + oldPass);
			System.out.println("new" + newPass);
			if (!updatePerson.getEmail().equals(email)) {
				editedPerson.setEmail(email);
			}
			if (!updatePerson.getFullName().equals(fullName)) {
				editedPerson.setFullName(fullName);
			}

			if (!updatePerson.getEmail().equals(email) || !updatePerson.getFullName().equals(fullName)) {
				new PersonService().updatePersonProfile(updatePerson, editedPerson);
				request.getRequestDispatcher("/WEB-INF/jsp/userProfile.jsp").forward(request, response);
			}
			if (!oldPass.equals("") || !newPass.equals("") || !oldPass.equals(null) || !newPass.equals(null)) {
				if (PersonService.encryptPassword(oldPass).equals(updatePerson.getPassword())) {
					System.out.println("kontrola stareho a noveho hesla");

					new PersonService().changePersonPassword(updatePerson, newPass);
				} else {
					request.setAttribute("passError", "false");
					System.out.println("nezodne hesla");
				}
			}
		}

	}

}
