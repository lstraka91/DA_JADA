package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.services.AdminService;

/**
 * Servlet implementation class ShowAdminsPermission, servlet that send to
 * Client arrayList of Admins persons
 */
@WebServlet("/showAdminsPermission")
public class ShowAdminsPermission extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {

			AdminService service = new AdminService();
			ArrayList<Admin> admins = new ArrayList<>();
			admins = service.showAllAdmins();
			request.setAttribute("admins", admins);

			forwardToList(request, response);
		} else {
			response.sendRedirect("/JADA_Tsystems_TeamProject/forum");
		}
	}

	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/showAdminsPermission.jsp").forward(request, response);
	}

}
