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
		if (session.getAttribute("user") != null) {

			session.setAttribute("countOfNotifi", new PersonService().getNumberOfActivationRequests());

			EntityManager em = JpaHelper.getEntityManager();
			Query query = em.createQuery("select p from Person p ");
			@SuppressWarnings("unchecked")
			ArrayList<Person> persons = (ArrayList<Person>) query.getResultList();

			String resetPass=request.getParameter("resetPass");
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
			if(resetPass!=null){
				String pName= request.getParameter("name");
				Person person = new PersonService().getPersonByName(pName);
				System.out.println(person);
				new PersonService().changePersonPassword(person, "123456798");
			}

			request.setAttribute("persons", persons);
			request.getRequestDispatcher("/WEB-INF/jsp/showUsers.jsp").forward(request, response);
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

		Person person = new Person();
		EntityManager em = JpaHelper.getEntityManager();

		if (request.getParameter("delete") != null) {

			person = new PersonService().getPersonByName(request.getParameter("delete"));
			PersonService personService = new PersonService();
			personService.setRemovedPerson(person);

			JpaHelper.beginTransaction();
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

		else if (request.getParameter("disable") != null) {
			JpaHelper.beginTransaction();
			person = new PersonService().getPersonByName(request.getParameter("dissable"));
			System.out.println(person.getFullName() + "   " + person.isActive());
			if (person != null) {
				person.setActive(false);
				System.out.println("****-----*****----*****---***---**-*-*-*-*-*-*");
			}
			JpaHelper.commitTransaction();

			System.out.println("-----------------------------------------------------------");
			System.out.println(person.getFullName() + "   " + person.isActive());

		}

		doGet(request, response);
	}

}
