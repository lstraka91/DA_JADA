package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.JpaHelper;
import sk.tsystems.jada.forum.entity.services.PersonService;

/**
 * Servlet implementation class ShowUsers
 */
@WebServlet("/ShowUsers")
public class ShowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {

			session.setAttribute("countOfNotifi", new PersonService().getNumberOfActivationRequests());

			EntityManager em = JpaHelper.getEntityManager();
			Query query = em.createQuery("select p from Person p ");
			@SuppressWarnings("unchecked")
			ArrayList<Person> persons = (ArrayList<Person>) query.getResultList();

			String resetPass = request.getParameter("resetPass");
			String action = request.getParameter("ordebBy");
			if (action != null) {
				if ("dType".equals(action)) {
					persons.clear();
					persons = (ArrayList<Person>) new PersonService().getPersonsOrderByDtype();
					request.setAttribute("orderBy", 1);
				}
				if ("activ".equals(action)) {
					persons.clear();
					persons = (ArrayList<Person>) new PersonService().getPersonsOrderByActiv();
					request.setAttribute("orderBy", 2);
				}
				if ("rDate".equals(action)) {
					persons.clear();
					persons = (ArrayList<Person>) new PersonService().getPersonsOrderByRegistrationDate();
					request.setAttribute("orderBy", 3);
				}
				if ("name".equals(action)) {
					persons.clear();
					persons = (ArrayList<Person>) new PersonService().getPersonsOrderByPersonName();
					request.setAttribute("orderBy", 4);
				}

			}
			if (resetPass != null) {
				String pName = request.getParameter("name");
				Person person = new PersonService().getPersonByName(pName);
				System.out.println(person);
				new PersonService().changePersonPassword(person, "123456");
			}

			request.setAttribute("persons", persons);
			request.getRequestDispatcher("/WEB-INF/jsp/showUsers.jsp").forward(request, response);
		} else {
			response.sendRedirect("forum");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String personToDelete = request.getParameter("delete");
		String personToActivate = request.getParameter("activate");
		String personToDissable = request.getParameter("dissable");

		if (personToDelete != null) {
			PersonService personService = new PersonService();
			personService.setRemovedPerson(personService.getPersonByName(personToDelete));
		}
		if (personToActivate != null) {
			new PersonService().activatePerson(personToActivate);
		}
		if (personToDissable != null) {
			new PersonService().dissablePerson(personToDissable);
		}
		doGet(request, response);
	}

}
