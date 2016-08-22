package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.List;

import sk.tsystems.jada.forum.dTO.CommentWithRating;
import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Topic;

public class CommentWithRatingService {

	/**
	 * method that returns null or List of object CommentWithRating. Function
	 * have to connect to the database and try to find all object Comment with
	 * rating for current Topic that is passed to this method by parameter. In
	 * database that search for comments to this topic and for current comment
	 * that is searching rating and count of rating to this comment, if there is
	 * no comment method returns null
	 * 
	 * @param topic
	 *            Object of type Topic for which are Comments and rating
	 *            searching
	 * @return null if Topic have no Comments on the other side that returns
	 *         List of CommentaryWithRating object that consist of Comment and
	 *         rating and count of rating to Comment
	 * @see CommentWithRatingService
	 */
	public List<CommentWithRating> getCommentsAndRatings(Topic topic) {
		List<CommentWithRating> dToList = new ArrayList<>();
		List<Commentary> comList = new ArrayList<>();
		CommentaryService cmntService = new CommentaryService();
		RatingService ratingServc = new RatingService();
		comList = cmntService.selectAllComentByTopic(topic);
		if (comList != null) {
			for (int i = 0; i < comList.size(); i++) {
				int rating = ratingServc.getRatingOfComment(comList.get(i));
				int count = ratingServc.getCountOfCommentRating(comList.get(i));
				CommentWithRating comWithRate = new CommentWithRating(comList.get(i), rating, count);
				dToList.add(comWithRate);
			}
			return dToList;
		}
		return null;
	}
}
