package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sk.tsystems.jada.forum.dTO.CommentWithRating;
import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Topic;

public class CommentWithRatingService {

	/**
	 * Method that returns null or List of object CommentWithRating. Function
	 * have to connect to the database and try to find all object Comment with
	 * rating for current Topic that is passed to this method by parameter. In
	 * database that search for comments to this topic and for current comment
	 * that is searching rating and count of rating to this comment, if there is
	 * no comment method returns null
	 * 
	 * Use the {@link CommentaryService #selectAllComentByTopic(Topic)} method
	 * 
	 * Use the {@link RatingService #getRatingOfComment(Commentary)} method
	 * 
	 * Use the {@link RatingService #getCountOfCommentRating(Commentary)} method
	 * 
	 * Use the {@link } method
	 * 
	 * @param topic
	 *            Object of type Topic for which are Comments and rating
	 *            searching
	 * 
	 * @return null if Topic have no Comments on the other side that returns
	 *         List of CommentaryWithRating object that consist of Comment and
	 *         rating and count of rating to Comment
	 * 
	 * @see CommentWithRating
	 * @see Topic
	 * @see Commentary
	 * @see CommentaryService
	 * @see RatingService
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

	/**
	 * Method that returns null or ordered List of object CommentWithRating
	 * ordered by rating. Function have to connect to the database and try to
	 * find all object Comment with rating for current Topic that is passed to
	 * this method by parameter. In database that search for comments to this
	 * topic and for current comment that is searching rating and count of
	 * rating to this comment, if there is no comment method returns null
	 * 
	 * Use the {@link CommentWithRatingService #getCommentsAndRatings(Topic)}
	 * method
	 * 
	 * Use the {@link CommentWithRating #getRateOfComment()} method
	 * 
	 * @param topic
	 *            Object of type Topic for which are Comments and rating
	 *            searching
	 * 
	 * @return null if Topic have no Comments on the other side that returns
	 *         ordered List of CommentaryWithRating object ordered by Rating
	 *         that consist of Comment and rating and count of rating to Comment
	 * 
	 * @see CommentWithRating
	 * @see Topic
	 */
	public List<CommentWithRating> getCommentsAndRatingsOrderedByRating(Topic topic) {
		List<CommentWithRating> comRateList = getCommentsAndRatings(topic);
		Collections.sort(comRateList, (c1, c2) -> c2.getRateOfComment() - c1.getRateOfComment());
		return comRateList;
	}

	/**
	 * Method that returns null or orderedList of object CommentWithRating
	 * ordered by Date. Function have to connect to the database and try to find
	 * all object Comment with rating for current Topic that is passed to this
	 * method by parameter. In database that search for comments to this topic
	 * and for current comment that is searching rating and count of rating to
	 * this comment, if there is no comment method returns null
	 * 
	 * Use the {@link CommentWithRatingService #getCommentsAndRatings(Topic)}
	 * method
	 * 
	 * Use the {@link CommentWithRating #getComment()} method
	 * 
	 * @param topic
	 *            Object of type Topic for which are Comments and rating
	 *            searching
	 * 
	 * @return null if Topic have no Comments on the other side that returns
	 *         List of CommentaryWithRating object ordered by Date that consist
	 *         of Comment and rating and count of rating to Comment
	 * 
	 * @see CommentWithRating
	 * @see Topic
	 */
	public List<CommentWithRating> getCommentsAndRatingsOrderedByDate(Topic topic) {
		List<CommentWithRating> comRateList = getCommentsAndRatings(topic);
		Collections.sort(comRateList,
				(c1, c2) -> c2.getComment().getCommentaryDate().compareTo(c1.getComment().getCommentaryDate()));
		return comRateList;
	}
}
