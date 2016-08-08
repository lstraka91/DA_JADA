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
 * Servlet implementation class Login
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
		int hashedPass = new PersonService().hashPassword(pass);
		System.out.println(userName);

		Person person = new PersonService().getPersonByNameAndPass(userName, hashedPass);

		if (person == null) {
			response.sendRedirect("/JADA_Tsystems_TeamProject/login");
		} else {
			System.out.println("Succes logged as " + person.getPersonName());
			request.getSession().setAttribute("user", person);
			response.sendRedirect("/JADA_Tsystems_TeamProject/forum");

		}

	}

}
