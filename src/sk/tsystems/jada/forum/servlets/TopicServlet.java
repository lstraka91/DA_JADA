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

import sk.tsystems.jada.forum.dTO.CommentWithRating;
import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Rating;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.CommentWithRatingService;
import sk.tsystems.jada.forum.entity.services.CommentaryService;
import sk.tsystems.jada.forum.entity.services.RatingService;
import sk.tsystems.jada.forum.entity.services.TopicService;

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

		Person person = (Person) session.getAttribute("user");

		int idTopic = Integer.parseInt(request.getParameter("idTopic"));
		Topic topic = new TopicService().findTopicById(idTopic);
		if (topic != null) {
			session.setAttribute("currentTopic", topic);
		}

		if (person != null) {
			new TopicService().addVisitorToTopic(topic, person.getIdPerson());
		}
		
		//delete owners comment
		if (request.getParameter("delete") != null && person != null && request.getParameter("idComment") != null) {
			int idComment = Integer.parseInt(request.getParameter("idComment"));
			Commentary comToDelete= new CommentaryService().selectCommentById(idComment);
			if(comToDelete!=null){
				new CommentaryService().removeCommentByObject(comToDelete);
			}
			
		}

		// int rate = (int) session.getAttribute("currentRating");
		if (request.getParameter("addRate") != null && person != null) {
			int idComment = Integer.parseInt(request.getParameter("idComment"));
			Rating rating;
			if (request.getParameter("addRate").equals("like")) {
				rating = new Rating(1, person, cs.selectCommentById(idComment));
				rs.addRating(rating);
			} else if (request.getParameter("addRate").equals("dislike")) {
				rating = new Rating(-1, person, cs.selectCommentById(idComment));
				rs.addRating(rating);
			}
		}
		String comment = request.getParameter("comment");
		if (comment != null & person != null) {
			topic = (Topic) session.getAttribute("currentTopic");
			Commentary com = new Commentary(comment, person, topic);
			cs.addComent(com);
		}
		String editComment = request.getParameter("editComment");
		if (editComment != null & person != null & request.getParameter("idComment")!=null) {
			int commentId= Integer.parseInt(request.getParameter("idComment"));
			topic = (Topic) session.getAttribute("currentTopic");
			Commentary commentToUpdate = cs.selectCommentById(commentId);
			cs.updateCommentBody(commentToUpdate, editComment);
		}

		List<Commentary> topicComment = new ArrayList<>();
		topicComment = (List<Commentary>) cs.selectAllComentByTopic(topic);
		request.setAttribute("topicComments", topicComment);

		List<CommentWithRating> topicCommentsWithRate = new CommentWithRatingService().getCommentsAndRatings(topic);
		if (topicCommentsWithRate != null) {
			request.setAttribute("commentWithRateList", topicCommentsWithRate);
		}
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
