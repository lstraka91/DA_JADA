package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.services.AdminService;

/**
 * Servlet implementation class UpdateAdmin, Servlet that have control of
 * updating all admins permision to all Admin person types
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {

			String name = request.getParameter("adminName").trim();
			if (name != null) {
				AdminService adminService = new AdminService();
				Admin admin = adminService.findAdminByName(name);
				request.setAttribute("admin", admin);
				request.setAttribute("adminName", admin.getPersonName());

				String action = request.getParameter("save");
				if (action != null) {
					boolean deleteTopic = request.getParameter("deleteTopic") != null;
					boolean deleteUser = request.getParameter("deleteUser") != null;
					boolean activateUser = request.getParameter("activateUser") != null;
					boolean deleteComment = request.getParameter("deleteComment") != null;
					System.out.println(deleteTopic + " " + deleteUser + "" + activateUser + "" + deleteComment);
					adminService.permissionUpdate(admin, deleteComment, deleteUser, deleteTopic, activateUser);
					response.sendRedirect("showAdminsPermission");
					return;
				}

			}
			forwardToList(request, response);
		} else {
			response.sendRedirect("forum");
		}
	}

	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/updateAdmin.jsp").forward(request, response);
	}

}
