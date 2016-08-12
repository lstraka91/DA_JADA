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
 * Servlet implementation class CheckOldPassword
 */
@WebServlet("/checkOldPassword")
public class CheckOldPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getParameter("password");
		Person person = (Person) request.getSession().getAttribute("user");
		if(new PersonService().hashPassword(pass)==person.getPassword()){
			response.getWriter().print("OK");
		}else{
			response.getWriter().println("<font color='red'>Password doesn't match with your current password!!</font>");
		}
	}

}
