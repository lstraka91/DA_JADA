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
	 * methot that try to save object from parameter to the Database by
	 * hibernate. in function is checking if the rating object allready exists
	 * in database and if no that its create a new one otherwise if exist it
	 * just update existing object to new values from parameter
	 * 
	 * @param rating
	 *            object of type Rating that should be update or added to
	 *            database
	 * @see Rating
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
	 * method to creating new Rating
	 * 
	 * @param rating
	 */
	private void createRating(Rating rating) {
		JpaHelper.beginTransaction();
		em.persist(rating);
		JpaHelper.commitTransaction();
	}

	/**
	 * method to update Rating
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
	 * function that return value sum of all rating for current Comment. That
	 * means that it should return negative or positive representation of rating
	 * default it returns zero if there is no matched results. But also zero
	 * could return if the count of added rating is zero.
	 * 
	 * @param comment
	 *            object for which is method searching the rating value
	 * @return sum of all ratings for current comment on success select and 0 if
	 *         select failed
	 * @see Commentary
	 */
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
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
	 * return an object of rating or null if object passes as parameter doesn't
	 * exists in database. Searching in database is by rating primary key and
	 * that method is use full just for checking if rating allready doesn't
	 * exist
	 * 
	 * @param rating
	 *            object of type Rating by which the method searching result
	 * @return object Rating or null if Entity notExist
	 * @see Rating
	 */
	@SuppressWarnings("unchecked")
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
	 * function that return value count of all rating for current Comment. That
	 * means that it should return zero if there is no matched result or value
	 * of count of all rating added to current comment that is passed to this
	 * method as parameter
	 * 
	 * @param comment
	 *            Comment object to which is count of rating searching
	 * @return count of rating or zero if there is no match
	 * @see Commentary
	 */
	@SuppressWarnings("unchecked")
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

	/**
	 * method that returns list of Rating objects or null if there is no match.
	 * Searching the database is by Person object parameter and it return all
	 * rating object if the rating was added by searched person
	 * 
	 * @param person
	 *            person by which is searching rating provided
	 * @return null if there is no match for current person or list of object
	 *         Rating
	 * @see Person
	 * @see Rating
	 */
	@SuppressWarnings("unchecked")
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
