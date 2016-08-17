package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.PersonService;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class Forum
 */
@WebServlet("/forum")
public class Forum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		List<Topic> topics = new ArrayList<>();

		session.setAttribute("countOfNotifi", new PersonService().getNumberOfActivationRequests());

		topics = (List<Topic>) session.getAttribute("topics");
		if (topics == null) {
			topics = (List<Topic>) new TopicService().getTopicsOrderDate();
			session.setAttribute("sorting", 1);
		}
		
		if (request.getParameter("idTopicDelete") != null) {
			System.out.println("ta co do pice kurwa tu....");
			TopicService ts = new TopicService();
			int idTopicDelete = Integer.parseInt(request.getParameter("idTopicDelete"));
			Topic topicDelete = ts.findTopicById(idTopicDelete);
			if (topicDelete != null) {
				ts.removeTopicById(idTopicDelete);
			}
		}

		String action = request.getParameter("action");
		if (action != null) {
			if ("new".equals(action)) {
				topics.sort((t1, t2) -> t1.getTopicDate().compareTo(t2.getTopicDate()));
				session.setAttribute("sorting", 1);
			}
			if ("top".equals(action)) {
				topics.sort((t1, t2) -> t1.getNumberOfViews() - t2.getNumberOfViews());
				session.setAttribute("sorting", 2);
			}
			if ("mostcommented".equals(action)) {
				topics.sort((t1, t2) -> t1.getNumberOfComments() - t2.getNumberOfComments());
				session.setAttribute("sorting", 3);
			}
			Collections.reverse(topics);

		}
		request.setAttribute("topics", topics);

		forwardToList(request, response);

	}
	
	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/forum.jsp").include(request, response);
	}

}
