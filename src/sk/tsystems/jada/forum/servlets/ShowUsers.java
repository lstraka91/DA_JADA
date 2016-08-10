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

import oracle.net.aso.i;
import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.AdminService;
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

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		AdminService service = new AdminService();
		ArrayList<Admin> admins = new ArrayList<>();
		admins = service.showAllAdmins();
		request.setAttribute("admins", admins);

		forwardToList(request, response);

	}
	
	

	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/showUsers.jsp").forward(request, response);
	}
}
