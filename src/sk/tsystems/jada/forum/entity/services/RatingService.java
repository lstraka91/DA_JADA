package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
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
		if (checkIfRatingExist(rating)) {
			createRating(rating);
		} else {
			int rate = rating.getRate();
			Rating existsRating = getRatingByRating(rating);
			updateRating(rate, existsRating);
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
	private void updateRating(int rate, Rating rating) {
		JpaHelper.beginTransaction();
		Rating updateRating = em.find(Rating.class, rating);
		updateRating.setRate(rate);
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
	 * @return true if Rating doesn't exist yet and false otherwise
	 */
	private boolean checkIfRatingExist(Rating rating) {
		ArrayList<Rating> ratingList = (ArrayList<Rating>) em
				.createQuery("Select r from Rating r where r.ratingIdCompositePK=:rid ")
				.setParameter("rid", rating.getRatingIdCompositePK()).getResultList();
		if (ratingList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Select Rating object from database
	 * 
	 * @param rating
	 * @return object Rating or null if Entity notExist
	 */
	public Rating getRatingByRating(Rating rating) {
		ArrayList<Rating> ratingList = (ArrayList<Rating>) em
				.createQuery("Select r from Rating r where r.ratingIdCompositePK=:rid ")
				.setParameter("rid", rating.getRatingIdCompositePK()).getResultList();
		if (ratingList.isEmpty()) {
			return null;
		} else {
			return ratingList.get(0);
		}
	}

	/**
	 * Select count of rating for current comment
	 * 
	 * @param comment
	 * @return count of rating
	 */
	public int getCountOfCommentRating(Commentary comment) {
		JpaHelper.beginTransaction();
		List<Long> countRating = em
				.createQuery(
						"select count(r.rate) from Rating r join r.ratingIdCompositePK c  where c.idCommentary=:idCom group by c.idCommentary")
				.setParameter("idCom", comment.getIdCommentary()).getResultList();
		JpaHelper.commitTransaction();
		if (countRating.size() > 0) {
			System.out.println(countRating.get(0).intValue());
			return countRating.get(0).intValue();
		} else {

			return 0;
		}
	}

	public List<Rating> selectAllRatingsByPerson(Person person) {

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT r FROM Rating r where r.ratingIdCompositePK.idPerson=:rid ");
		query.setParameter("rid", person.getIdPerson());

		if (!query.getResultList().isEmpty()) {
			List<Rating> resultList = query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}
}
