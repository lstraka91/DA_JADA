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
 * Servlet for logining user to Application. On succces is Person object save to
 * the Session to identify logged user
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String pass = request.getParameter("password");
		System.out.println(userName);

		Person person = new PersonService().getPersonByNameAndPass(userName, pass);

		loginUser(request, response, person);

	}

	/**
	 * method that try to login person to the WebApplication, if succes the
	 * Person object is saved to Session otherwise response send info about bad
	 * login or not activated person
	 * 
	 * @param request request object
	 * @param response response object
	 * @param person Person that trying to log in to WebApplication
	 * @throws IOException
	 */
	public void loginUser(HttpServletRequest request, HttpServletResponse response, Person person) throws IOException {
		if (person == null) {
			response.getWriter().print("error");
		} else {
			System.out.println("Succes logged as " + person.getPersonName());
			request.getSession().setAttribute("user", person);
			response.sendRedirect("forum");

		}
	}

}
