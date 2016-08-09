package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.type.AdaptedImmutableType;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.services.AdminService;
import sk.tsystems.jada.forum.entity.services.PersonService;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		AdminService adminService = new AdminService();
		Admin admin = adminService.findAdminByName("Jano");

		request.setAttribute("personName", admin.getPersonName());
		request.setAttribute("fullName", admin.getFullName());
		request.setAttribute("birthday", admin.getBirthday());
		request.setAttribute("email", admin.getEmail());
		request.setAttribute("deleteCommentr", admin.isDeleteCommentPermission());
		request.setAttribute("deleteUser", admin.isDeleteUserPermission());
		request.setAttribute("deleteTopic", admin.isDeleteTopicPermission());
		request.setAttribute("activatedUser", admin.isActivationUserPernmision());
		
		System.out.println("admin : " + admin.getFullName());

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		
	}
	
	

}
