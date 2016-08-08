package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.services.AdminService;

/**
 * Servlet implementation class PermissioUpdate
 */
@WebServlet("/PermissioUpdate")
public class PermissioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PermissioUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();

		Admin admin = new Admin();
		AdminService adminService = new AdminService();

		adminService.showAllAdmins();
		ArrayList<Admin> list = adminService.showAllAdmins();
		out.print("<table>");
		for (int i = 0; i < list.size(); i++) {
			out.print("<tr>");
			out.println("<td>"+ list.get(i).getPersonName() + " <td> " + list.get(i).isDeleteUserPermission()
					+ " <td> " + list.get(i).isDeleteCommentPermission() + " </td> "
					+ list.get(i).isDeleteTopicPermission() + "<td> "
					+ list.get(i).isActivationUserPernmision());
			out.print("</tr>");
		}
		out.print("</table>");
		
		adminService.findAdminByName("Fero");
		adminService.permissionUpdate(adminService.findAdminByName("Fero"), false, false, false, false);
		
		
		adminService.showAllAdmins();
		ArrayList<Admin> list1 = adminService.showAllAdmins();
		out.print("<table>");
		for (int i = 0; i < list1.size(); i++) {
			out.print("<tr>");
			out.println("<td>"+ list1.get(i).getPersonName() + " <td> " + list1.get(i).isDeleteUserPermission()
					+ " <td> " + list1.get(i).isDeleteCommentPermission() + " </td> "
					+ list1.get(i).isDeleteTopicPermission() + "<td> "
					+ list1.get(i).isActivationUserPernmision());
			out.print("</tr>");
		}
		out.print("</table>");
		
		
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
