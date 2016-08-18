package sk.tsystems.jada.forum.servlets;

import java.io.IOException;
import java.util.Arrays;
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
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.KeyWordService;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class EditTopic
 */
@WebServlet("/editTopic")
public class EditTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TopicService ts = new TopicService();

		HttpSession session = request.getSession();

		String topicName = request.getParameter("topicname");
		String topicDescription = request.getParameter("topicdescription");
		String keyWordsString = request.getParameter("keyWords");

		if (request.getParameter("idTopic") != null) {
			int idTopic = Integer.parseInt(request.getParameter("idTopic"));
			Topic topic = ts.findTopicById(idTopic);
			if (topic != null) {
				session.setAttribute("currentTopic", topic);
			}
			if (keyWordsString != null) {
				List<String> keyWordsList = Arrays.asList(keyWordsString.split(","));
				Set<KeyWord> keyWords = new HashSet<>();
				if (!keyWordsList.isEmpty())
					for (String kWString : keyWordsList) {
						if (kWString != null && !kWString.isEmpty()) {
							KeyWord tempKW = new KeyWordService().findKeyWord(kWString);
							keyWords.add(tempKW);
						}
					}
				if (topicName != null & topicDescription != null) {
					ts.updateTopic(idTopic, topicName, topicDescription, keyWords);
					response.sendRedirect("/JADA_Tsystems_TeamProject/topic?idTopic=" + idTopic);
				}
			}
		}

		forwardToList(request, response);
	}
	
	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/editTopic.jsp").include(request, response);
	}
}
