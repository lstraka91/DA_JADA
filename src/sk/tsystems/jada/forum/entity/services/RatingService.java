package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Rating;

public class RatingService {

	/**
	 * Entity manager object
	 */
	private EntityManager em;

	/**
	 * Constructor of RatingService
	 */
	public RatingService() {
		em = JpaHelper.getEntityManager();
	}

	/**
	 * function that add rating to DB
	 * 
	 * @param rating
	 */
	public void addRating(Rating rating) {

		if (checkIfRatingExist(rating).equals(null)) {
			createRating(rating);

		} else {
			updateRating(rating);
		}
	}

	/**
	 * create new Rating
	 * 
	 * @param rating
	 */
	private void createRating(Rating rating) {
		JpaHelper.beginTransaction();
		em.persist(rating);
		JpaHelper.commitTransaction();
	}

	/**
	 * update Rating
	 * 
	 * @param rating
	 */
	private void updateRating(Rating rating) {
		JpaHelper.beginTransaction();
		Rating updateRating = em.find(Rating.class, checkIfRatingExist(rating));
		updateRating.setRate(rating.getRate());
		em.persist(updateRating);
		JpaHelper.commitTransaction();
	}

	/**
	 * function that return integer sum of all rating for current Comment
	 * 
	 * @param comment
	 * @return sum of all ratings for current comment on succes select and 0 if
	 *         select failed
	 */
	public int getRatingOfComment(Commentary comment) {
		JpaHelper.beginTransaction();
		List<Long> sumRating = em
				.createQuery(
						"select sum(r.rate) from Rating r join r.ratingIdCompositePK c  where c.idCommentary=:idCom group by c.idCommentary")
				.setParameter("idCom", comment.getIdCommentary()).getResultList();
		JpaHelper.commitTransaction();
		if (sumRating.size() > 0) {
			System.out.println(sumRating.get(0).intValue());
			return sumRating.get(0).intValue();

		} else
			return 0;
	}

	/**
	 * method that checks if Rating exists
	 * 
	 * @param rating
	 * @return Rating from DB or null if Rating doesn't exist yet
	 */
	private Rating checkIfRatingExist(Rating rating) {
		ArrayList<Rating> ratingList = (ArrayList<Rating>) em
				.createQuery("Select r from Rating r where r.ratingIdCompositePK=:rid ")
				.setParameter("rid", rating.getRatingIdCompositePK()).getResultList();
		System.out.println(ratingList.size());
		if (ratingList.size() > 0) {
			return ratingList.get(0);
		} else {
			return null;
		}
	}

}
