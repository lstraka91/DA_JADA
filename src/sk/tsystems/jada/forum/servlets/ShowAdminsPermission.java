package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.services.AdminService;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class PermissioUpdate
 */
@WebServlet("/showAdminsPermission")
public class ShowAdminsPermission extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		request.getRequestDispatcher("/WEB-INF/jsp/showAdminsPermission.jsp").forward(request, response);
	}

}
