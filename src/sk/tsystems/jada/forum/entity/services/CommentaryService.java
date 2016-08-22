package sk.tsystems.jada.forum.entity.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;

public class CommentaryService {

	/**
	 * Method for add comment to database
	 * 
	 * @param comment
	 *            object of Commentary
	 * 
	 * @see Commentary
	 */
	public void addComent(Commentary comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(comment);
		JpaHelper.commitTransaction();
	}

	/**
	 * Select all comments from database
	 * 
	 * @return List of object Commentary
	 * 
	 * @see Commentary
	 */
	@SuppressWarnings("unchecked")
	public List<Commentary> selectAllComent() {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		List<Commentary> list = em.createQuery("SELECT c FROM Commentary c").getResultList();
		return list;
	}

	/**
	 * Select all comments from database by topic
	 * 
	 * @param topic
	 *            object of type Topic
	 * 
	 * @return List of object Commentary by topic
	 * 
	 * @see Commentary
	 * @see Topic
	 */
	@SuppressWarnings("unchecked")
	public List<Commentary> selectAllComentByTopic(Topic topic) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Commentary c where c.topic.idTopic = :idTopic ");
		query.setParameter("idTopic", topic.getIdTopic());
		if (!query.getResultList().isEmpty()) {
			List<Commentary> resultList = query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	/**
	 * Select all comments from database by person
	 * 
	 * @param person
	 *            object of type Person
	 * 
	 * @return List of object Commentary by person
	 * 
	 * @see Commentary
	 * @see Person
	 */
	@SuppressWarnings("unchecked")
	public List<Commentary> selectAllComentByPerson(Person person) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Commentary c where c.person.idPerson = :idPerson ");
		query.setParameter("idPerson", person.getIdPerson());
		if (!query.getResultList().isEmpty()) {
			List<Commentary> resultList = query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	/**
	 * Remove comment from database by identifier comment
	 * 
	 * @param idComment
	 *            identifier of comment
	 * 
	 * @see Commentary
	 */
	public void removeCommentById(int idComment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Commentary toDelete = em.find(Commentary.class, idComment);
		em.remove(toDelete);
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for remove comment from database by object of type Commentary,
	 * with help of method SelectCommentById get object Commentary
	 * 
	 * Use the {@link CommentaryService #selectCommentById(integer)} method
	 * 
	 * @param comment
	 *            object of type Commentary
	 * 
	 * @see Commentary
	 */
	public void removeCommentByObject(Commentary comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		comment = selectCommentById(comment.getIdCommentary());
		em.remove(comment);
		JpaHelper.commitTransaction();
	}

	/**
	 * Select Commentary object from database by identifier of comment
	 * 
	 * @param idComment
	 *            identifier of comment
	 * @return object of type Commentary or null if select failed and have no
	 *         result for the current identifier comment
	 * 
	 * @see Commentary
	 */
	@SuppressWarnings("unchecked")
	public Commentary selectCommentById(int idComment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Commentary c where c.idCommentary = :idComment ");
		query.setParameter("idComment", idComment);
		if (!query.getResultList().isEmpty()) {
			List<Commentary> resultList = query.getResultList();
			return resultList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Method for return object of type Commentary by comment body
	 * 
	 * @param commentaryBody
	 *            body of comment
	 * 
	 * @return object of type Commentary or null if select failed and have no
	 *         result for the current comment body
	 * 
	 * @see Commentary
	 */
	public Commentary getCommentByText(String commentaryBody) {
		Commentary comment;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select c from Commentary c where c.commentaryBody = :commentaryBody");
		query.setParameter("commentaryBody", commentaryBody);
		if (!query.getResultList().isEmpty()) {
			comment = (Commentary) query.getResultList().get(0);
			return comment;
		} else {
			return null;
		}
	}

	/**
	 * Method for update comment body by object of type Commentary
	 * 
	 * Use the {@link Commentary #setCommentaryBody(String)} method
	 * 
	 * @param comment
	 *            object of type Commentary
	 * 
	 * @param commentaryBody
	 *            body of comment
	 * 
	 * @see Commentary
	 */
	public void updateCommentBody(Commentary comment, String commentaryBody) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Commentary commentToEdit = em.find(Commentary.class, comment.getIdCommentary());
		commentToEdit.setCommentaryBody(commentaryBody);
		JpaHelper.commitTransaction();
	}
}
