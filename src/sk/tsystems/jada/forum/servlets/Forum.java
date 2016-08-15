package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class Forum
 */
@WebServlet("/forum")
public class Forum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		List<Topic> topics = new ArrayList<>();

		topics = (List<Topic>) new TopicService().showTopics();

		request.setAttribute("topics", topics);

		String action = request.getParameter("action");
		if (action != null) {
			if ("top".equals(action)) {
				System.out.println("show top viewed topics");
			}
			if ("mostcommented".equals(action)) {
				System.out.println("show top viewed topics");
			}
		}
		forwardToList(request, response);

	}

	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/forum.jsp").forward(request, response);
	}

}
