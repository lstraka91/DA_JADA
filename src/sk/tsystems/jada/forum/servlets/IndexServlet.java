package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.tsystems.jada.forum.entity.services.GenerateBasicDbs;
import sk.tsystems.jada.forum.entity.services.PersonService;


/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initForum();
		request.getRequestDispatcher("/WEB-INF/jsp/forum.jsp").forward(request, response);
	}

	public void initForum() {
		if(new PersonService().getPersonByName("superAdmin")==null){
			new GenerateBasicDbs().generateDbs();
		}
		
	}
}
