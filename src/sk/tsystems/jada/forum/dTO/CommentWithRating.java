package sk.tsystems.jada.forum.dTO;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Rating;

public class CommentWithRating {

	/**
	 * Commentary object 
	 */
	private Commentary comment;
	/**
	 * int value of rate for the current comment
	 */
	private int rateOfComment;
	/**
	 * count of rating for the current comment
	 */
	private int countOfCommentsRating;

	/**
	 * Constructor that return DtO object of Comment with rating and count of ratings
	 * @param comment
	 * @param rateOfComment
	 * @param countOfCommentsRating
	 */
	public CommentWithRating(Commentary comment, int rateOfComment, int countOfCommentsRating) {
		this.comment = comment;
		this.rateOfComment = rateOfComment;
		this.countOfCommentsRating = countOfCommentsRating;
	}

	/**
	 * Get Commentary object
	 * 
	 * @return comment
	 */
	public Commentary getComment() {
		return comment;
	}

	/**
	 * get rate of Comment
	 * 
	 * @return integer value of rating
	 */
	public int getRateOfComment() {
		return rateOfComment;
	}

	/**
	 * get count of rating to current comment
	 * 
	 * @return integer value of count
	 */
	public int getCountOfCommentsRating() {
		return countOfCommentsRating;
	}

}
