package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class NewTopic
 */
@WebServlet("/newtopic")
public class NewTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		if ("addtopic".equals(action)) {
			Topic newTopic = new Topic();
			newTopic.setPerson((Person) session.getAttribute("user"));
			newTopic.setTopicDate(new Date());
			newTopic.setTopicName(request.getParameter("topicName"));
			newTopic.setTopicDescription(request.getParameter("topicDesc"));

			System.out.println("keywords: " + request.getParameter("keyWords"));

			System.out.println(newTopic.toString());
			 new TopicService().addTopic(newTopic);
			response.sendRedirect("/JADA_Tsystems_TeamProject/newtopic");

		}

		forwardToList(request, response);

	}

	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/newTopic.jsp").include(request, response);
	}

}
