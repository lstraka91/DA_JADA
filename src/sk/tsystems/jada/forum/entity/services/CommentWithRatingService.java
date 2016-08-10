package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.List;

import sk.tsystems.jada.forum.dTO.CommentWithRating;
import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Topic;

public class CommentWithRatingService {

	/**
	 * method that return List of CommentWithRating object from database
	 * 
	 * @param topic
	 * @return List of CommentWithRating object
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
