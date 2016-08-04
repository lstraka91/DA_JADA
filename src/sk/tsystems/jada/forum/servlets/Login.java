package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.JpaHelper;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String userName = request.getParameter("userName");
		 String pass = request.getParameter("password");
	      //  String passwd = request.getParameter("pass");
	        JpaHelper.beginTransaction();
			 EntityManager em = JpaHelper.getEntityManager();
			 JpaHelper.commitTransaction();
			 ArrayList<Person>personList= (ArrayList<Person>) em.createQuery("Select p from Player p where p.name=:name AND p.password=:password").setParameter("name", userName).setParameter("password", pass).getResultList();
			 
//			 if(personList.isEmpty()){
//				 request.setAttribute("error", "DACO NEDOBRE");
//				 response.sendRedirect("/loginUser?error='invalid'");
//			 }else if (personList.size()==1){
				 request.getSession().setAttribute("user", personList.get(0));
//				 response.sendRedirect("/GameCenter/games");
				 request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
								
			 
	}

}
