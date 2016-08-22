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
 * Servlet implementation class LoginCheck, checks if user that trying to log in
 * is activated or not if user is activated, response is with OK message
 * otherwise error message is sent to Client
 */
@WebServlet("/loginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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

		if (person == null) {
			response.getWriter().print("error");
			// request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").include(request,
			// response);
		} else {
			System.out.println(person.isActive());
			if (person.isActive()) {
				System.out.println("Succes logged as " + person.getPersonName());
				request.getSession().setAttribute("user", person);
				response.sendRedirect("/JADA_Tsystems_TeamProject/forum");
			} else {
				response.getWriter().print("notActivated");
			}

		}
	}

}
