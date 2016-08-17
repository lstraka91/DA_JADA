package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sk.tsystems.jada.forum.entity.KeyWord;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.KeyWordService;
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

			String keyWordsString = request.getParameter("keyWords");

			if (keyWordsString != null) {
				List<String> keyWordsList = Arrays.asList(keyWordsString.split(","));
				Set<KeyWord> kWSet = new HashSet<>();
				if (!keyWordsList.isEmpty())
					for (String kWString : keyWordsList) {
						if (kWString != null && !kWString.isEmpty()) {
							KeyWord tempKW = new KeyWordService().findKeyWord(kWString);
							kWSet.add(tempKW);
						}
					}
				newTopic.setKeyWords(kWSet);
			}
			new TopicService().addTopic(newTopic);
			response.sendRedirect("/JADA_Tsystems_TeamProject/forum");
		}
		session.setAttribute("topics", null);

		forwardToList(request, response);

	}

	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/newTopic.jsp").include(request, response);
	}

}
