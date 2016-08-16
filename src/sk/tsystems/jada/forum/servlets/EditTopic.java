package sk.tsystems.jada.forum.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class EditTopic
 */
@WebServlet("/editTopic")
public class EditTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int idTopic = Integer.parseInt(request.getParameter("idTopic"));
		Topic topic = new TopicService().findTopicById(idTopic);
		if (topic != null) {
			session.setAttribute("currentTopic", topic);
		}
		
		request.setAttribute("editedTopic", topic);
		
		forwardToList(request, response);
	}
	
	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/editTopic.jsp").forward(request, response);
	}
}
