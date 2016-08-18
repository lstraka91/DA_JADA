package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidatePass
 */
@WebServlet("/validatePass")
public class ValidatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = request.getParameter("password");
		String passC= request.getParameter("passC");
//		String pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

		System.out.println(pass+" druhe hesloo"+ passC);
		if (pass.equals(passC)) {
			System.out.println("PASSWORDS VALIDATION OKEEEEEEEEEEEY");
			response.getWriter().print("OK");
		} else {
			System.out.println("CRASH VALIDATION!!!!!!!!! ");
			response.getWriter().println(
					"<font color='red'>Passwords are not matched!! </font>");
		}
	}

}
