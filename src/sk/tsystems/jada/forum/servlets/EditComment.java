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
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.CommentWithRatingService;
import sk.tsystems.jada.forum.entity.services.CommentaryService;
import sk.tsystems.jada.forum.entity.services.TopicService;

/**
 * Servlet implementation class EditComment
 */
@WebServlet("/editComment")
public class EditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		CommentaryService cs = new CommentaryService();

		if (session.getAttribute("user") != null) {

			int idTopic = Integer.parseInt(request.getParameter("idTopic"));
			Topic topic = new TopicService().findTopicById(idTopic);
			if (topic != null) {
				session.setAttribute("currentTopic", topic);
			}

			List<Commentary> topicComment = new ArrayList<>();
			topicComment = (List<Commentary>) cs.selectAllComentByTopic(topic);
			request.setAttribute("topicComments", topicComment);

			List<CommentWithRating> topicCommentsWithRate = new CommentWithRatingService().getCommentsAndRatings(topic);
			if (topicCommentsWithRate != null) {
				request.setAttribute("commentWithRateList", topicCommentsWithRate);
			}
			// ORIGINAL PISANE V EDIT COMMENT
			if (request.getParameter("commentaryBody") != null) {

				String commentBody = request.getParameter("commentaryBody").trim();
				System.out.println(commentBody);
				if (request.getParameter("idComment") != null && request.getParameter("idTopic") != null) {

					int idComment = Integer.parseInt(request.getParameter("idComment"));
					int idTopicc = Integer.parseInt(request.getParameter("idTopic"));
					request.setAttribute("idTopic", idTopicc);
					request.setAttribute("idComment", idComment);
				}
				request.setAttribute("commentaryBody", commentBody);
			}

			request.getRequestDispatcher("/WEB-INF/jsp/editComment.jsp").forward(request, response);
		} else {
			response.sendRedirect("/JADA_Tsystems_TeamProject/forum");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String editComment = request.getParameter("editComment");
		if (editComment != null & request.getParameter("idComment") != null) {
			int commentId = Integer.parseInt(request.getParameter("idComment"));
			int topicId = Integer.parseInt(request.getParameter("idTopic"));
			Commentary commentToUpdate = new CommentaryService().selectCommentById(commentId);
			new CommentaryService().updateCommentBody(commentToUpdate, editComment);
			response.sendRedirect("/JADA_Tsystems_TeamProject/topic?idTopic=" + topicId);

		}
	}

}
