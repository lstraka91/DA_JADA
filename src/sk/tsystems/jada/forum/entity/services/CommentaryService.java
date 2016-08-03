package sk.tsystems.jada.forum.entity.services;

import java.util.List;

import javax.persistence.EntityManager;

import sk.tsystems.jada.forum.entity.Commentary;

public class CommentaryService {

	/**
	 * Insert Comment into DB
	 * 
	 * @param comment
	 */
	public void addComent(Commentary comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(comment);
		JpaHelper.commitTransaction();
	}

	/**
	 * Select all comment from DB
	 * 
	 * @return List<Commentary>
	 */
	public List<Commentary> selectAllComent() {

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();
		List<Commentary> list = em.createQuery("SELECT c FROM CommentJPA c where c.game.gameID = '' ").getResultList();

		return list;
	}

	/**
	 * sSelect comment by Topic
	 * 
	 * @return List<Commentary>
	 */
	public List<Commentary> selectAllComentByTopic() {

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();
		List<Commentary> list = em.createQuery("SELECT c FROM CommentJPA c where c.game.gameID = '' ").getResultList();

		return list;
	}

	/**
	 * Select comment by Person
	 * 
	 * @return List<Commentary>
	 */
	public List<Commentary> selectAllComentByPerson() {

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();
		List<Commentary> list = em.createQuery("SELECT c FROM CommentJPA c where c.game.gameID = '' ").getResultList();

		return list;
	}

	/**
	 * Remove comment by ID
	 * 
	 * @param id
	 */
	public void removeCommentById(int id) {
		Commentary comment = new Commentary();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		comment = em.find(Commentary.class, id);
		em.remove(comment);
		JpaHelper.commitTransaction();
	}

	/**
	 * Remove comment by object
	 * 
	 * @param comment
	 */
	public void removeCommentByObject(Commentary comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		comment = em.find(Commentary.class, comment);
		em.remove(comment);
		JpaHelper.commitTransaction();
	}

}
