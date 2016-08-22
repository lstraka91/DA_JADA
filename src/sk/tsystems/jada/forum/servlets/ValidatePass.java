package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that checks the validation of two passwords that client input in browser
 * before succes registration, and checks if two passwords equals
 */
@WebServlet("/validatePass")
public class ValidatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Http POST method that checks password validation. return response with
	 * some messages if result is OK or validation fails
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pass = request.getParameter("password");
		String passC = request.getParameter("passC");
		// System.out.println(pass + " druhe hesloo" + passC);
		checkPasswordEquals(response, pass, passC);
	}

	/**
	 * Method that checks if two passwords from Client input form equals and return response with result message
	 * @param response Http response object
	 * @param pass password from user input to check if equals with other
	 * @param passC password from user input to check if equals with other
	 * @throws IOException 
	 */
	public void checkPasswordEquals(HttpServletResponse response, String pass, String passC) throws IOException {
		if (pass.equals(passC)) {
			System.out.println("PASSWORDS VALIDATION OKEEEEEEEEEEEY");
			response.getWriter().print("OK");
		} else {
			System.out.println("CRASH VALIDATION!!!!!!!!! ");
			response.getWriter().println("<font color='red'>Passwords are not matched!! </font>");
		}
	}

}
