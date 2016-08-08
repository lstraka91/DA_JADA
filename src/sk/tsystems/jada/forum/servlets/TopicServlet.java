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

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Rating;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.CommentaryService;
import sk.tsystems.jada.forum.entity.services.RatingService;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		CommentaryService cs = new CommentaryService();

		RatingService rs = new RatingService();

		String comment = request.getParameter("comment");
		Person person = (Person) session.getAttribute("user");
		Topic topic = (Topic) session.getAttribute("currentTopic");
		int rate = (int) session.getAttribute("currentRating");

		Commentary com = new Commentary(comment, person, topic);
		cs.addComent(com);

		Rating rating = new Rating(rate, person, com);
		rs.addRating(rating);

		List<Commentary> topicComment = new ArrayList<>();
		topicComment = (List<Commentary>) cs.selectAllComentByTopic(topic);
		request.setAttribute("topicComments", topicComment);
		
		int topicRating = rs.getRatingOfComment(com);
		request.setAttribute("topicRating", topicRating);

		forwardToList(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/topic.jsp").forward(request, response);
	}

}
