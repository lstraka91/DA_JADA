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
import sk.tsystems.jada.forum.entity.services.ChangePersonTypeService;
import sk.tsystems.jada.forum.entity.services.JpaHelper;
import sk.tsystems.jada.forum.entity.services.PersonService;

/**
 * Servlet implementation class ChangePersonType, servlet in which logged
 * SuperADmin could changing type of person to another types and could create
 * Admin or Superadmins from Person object type or Downgrade back to Person.
 */
@WebServlet("/changePersonType")
public class ChangePersonType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {

			EntityManager em = JpaHelper.getEntityManager();
			Query query = em.createQuery("select p from Person p ");
			ArrayList<Person> persons = (ArrayList<Person>) query.getResultList();

			String action = request.getParameter("ordebBy");
			if (action != null) {
				if ("dType".equals(action)) {
					persons.clear();
					persons = (ArrayList<Person>) new PersonService().getPersonsOrderByDtype();
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
			String changeTo = request.getParameter("changeTo");
			String personName = request.getParameter("personName");
			if (changeTo != null && personName != null) {
				Person person = new PersonService().getPersonByName(personName);
				if (changeTo.equals("admin")) {
					new ChangePersonTypeService().changePersonToAdmin(person);
					request.removeAttribute("changeTo");
				} else if (changeTo.equals("person")) {
					new ChangePersonTypeService().changeAdminToPerson(person);
					request.removeAttribute("changeTo");
				} else if (changeTo.equals("superAdmin")) {
					new ChangePersonTypeService().changePersonToSuperAdmin(person);
					request.removeAttribute("changeTo");
				}
				response.sendRedirect("changePersonType");
				return;
			}

			request.setAttribute("persons", persons);
			request.getRequestDispatcher("/WEB-INF/jsp/changePersonType.jsp").forward(request, response);
		} else {
			response.sendRedirect("forum");
		}
	}
}
