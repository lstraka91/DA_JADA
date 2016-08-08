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
 * Servlet implementation class CheckUsername
 */
@WebServlet("/checkUsername")
public class CheckUsername extends HttpServlet {
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
		String personName = request.getParameter("userName").trim();
		if (personName != null) {
			System.out.println("wohooo z checkUsername" + personName);
			Person person = new PersonService().getPersonByName(personName);
			if (person == null) {
				response.getWriter().print("OK");
			} else {
				response.getWriter().println("<font color='red'>The nickname <strong>"+person.getPersonName()+"</strong> is already in use.</font>");
			}

		}
	}

}
