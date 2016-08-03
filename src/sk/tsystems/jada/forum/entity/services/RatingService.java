package sk.tsystems.jada.forum.entity.services;

import javax.persistence.EntityManager;

import sk.tsystems.jada.forum.entity.Rating;


public class RatingService {

	
	public void addRating(Rating rating){
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(rating);
		JpaHelper.commitTransaction();
	}
}
