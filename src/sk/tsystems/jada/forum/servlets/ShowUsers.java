package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.i;
import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.AdminService;
import sk.tsystems.jada.forum.entity.services.JpaHelper;
import sk.tsystems.jada.forum.entity.services.PersonService;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class ShowUsers
 */
@WebServlet("/ShowUsers")
public class ShowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		session.setAttribute("countOfNotifi", new PersonService().getNumberOfActivationRequests());

		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p ");
		ArrayList<Person> persons = (ArrayList<Person>) query.getResultList();

		String action = request.getParameter("ordebBy");
		if (action != null) {
			if ("dType".equals(action)) {
				persons.clear();
				persons = (ArrayList<Person>) new PersonService().getPersonsOrderByDtype();
			}
			if ("activ".equals(action)) {
				persons.clear();
				persons = (ArrayList<Person>) new PersonService().getPersonsOrderByActiv();

			}
			if ("rDate".equals(action)) {
				persons.clear();
				persons = (ArrayList<Person>) new PersonService().getPersonsOrderByRegistrationDate();

			}
			if ("name".equals(action)) {
				persons.clear();
				persons = (ArrayList<Person>) new PersonService().getPersonsOrderByPersonName();

			}

		}

		request.setAttribute("persons", persons);
		request.getRequestDispatcher("/WEB-INF/jsp/showUsers.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Person person = new Person();
		EntityManager em = JpaHelper.getEntityManager();

		if (request.getParameter("delete") != null) {

			JpaHelper.beginTransaction();
			person = new PersonService().getPersonByName(request.getParameter("delete"));
			if (person != null) {
				em.remove(person);
			}
			JpaHelper.commitTransaction();
		}

		else if (request.getParameter("activate") != null) {
			JpaHelper.beginTransaction();
			person = new PersonService().getPersonByName(request.getParameter("activate"));
			System.out.println(person.getFullName() + "   " + person.getBirthday());
			if (person != null) {
				person.setActive(true);
				System.out.println("****-----*****----*****---***---**-*-*-*-*-*-*");
			}
			JpaHelper.commitTransaction();

			System.out.println("-----------------------------------------------------------");
		}

		doGet(request, response);
	}

}
