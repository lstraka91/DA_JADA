package sk.tsystems.jada.forum.dTO;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Rating;

public class CommentWithRating {

	private Commentary comment;
	private Rating rating;
	private int rateOfComment;
	
	public CommentWithRating(Commentary comment, int rateOfComment) {
		this.comment = comment;
		this.rating = rating;
		this.rateOfComment = rateOfComment;
	}

	public Commentary getComment() {
		return comment;
	}

	public void setComment(Commentary comment) {
		this.comment = comment;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public int getRateOfComment() {
		return rateOfComment;
	}

	public void setRateOfComment(int rateOfComment) {
		this.rateOfComment = rateOfComment;
	}
	
	
	
	
	
}
