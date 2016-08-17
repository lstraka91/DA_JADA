package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.JpaHelper;

/**
 * Servlet implementation class Notification
 */
@WebServlet("/Notification")
public class Notification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out = response.getWriter();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p");
		int count = 0;
		ArrayList<Person> resultList = (ArrayList<Person>) query.getResultList();
		for (int i = 0; i < resultList.size(); i++) {

			if (resultList.get(i).isActive() == false) {
				count++;
			}
		}
		
		request.setAttribute("countOfNotifi", count);
		
		
	
	//	request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
