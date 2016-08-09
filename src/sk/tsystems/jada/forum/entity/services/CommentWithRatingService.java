package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.List;

import sk.tsystems.jada.forum.dTO.CommentWithRating;
import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Topic;

public class CommentWithRatingService {

	public List<CommentWithRating> getCommentsAndRatings(Topic topic){
		List<CommentWithRating> dToList= new ArrayList<>();
		CommentaryService cmntService = new CommentaryService();
		RatingService ratingServc= new RatingService();
		List<Commentary> comList = cmntService.selectAllComentByTopic(topic);
		for (int i = 0; i < comList.size(); i++) {
			
			int rating = ratingServc.getRatingOfComment(comList.get(i));
			CommentWithRating comWithRate = new CommentWithRating(comList.get(i), rating);
			dToList.add(comWithRate);
		}
		return dToList;
	}
}
