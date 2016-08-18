package sk.tsystems.jada.forum.entity.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;

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
	@SuppressWarnings("unchecked")
	public List<Commentary> selectAllComent() {

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		List<Commentary> list = em.createQuery("SELECT c FROM Commentary c").getResultList();

		return list;
	}

	/**
	 * sSelect comment by Topic
	 * 
	 * @return List<Commentary>
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
	 * Select comment by Person
	 * 
	 * @return List<Commentary>
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
	 * Remove comment by ID
	 * 
	 * @param id
	 */
	public void removeCommentById(int id) {
		// Commentary comment = new Commentary();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		// comment = selectCommentById(id);
		// System.out.println(comment.getIdCommentary());
		Commentary toDelete = em.find(Commentary.class, id);
		System.out.println(toDelete.idCommentary);
		em.remove(toDelete);
		JpaHelper.commitTransaction();
	}

	/**
	 * Remove comment by object
	 * 
	 * @param comment
	 * 
	 */
	public void removeCommentByObject(Commentary comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		comment = selectCommentById(comment.getIdCommentary());
		em.remove(comment);
		JpaHelper.commitTransaction();
	}

	/**
	 * Select Commentary object from Database by id of COmment
	 * 
	 * @param id
	 * @return return Commentary object or null if select failed and have no
	 *         result for the current Id
	 */
	@SuppressWarnings("unchecked")
	public Commentary selectCommentById(int id) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Commentary c where c.idCommentary = :idComment ");
		query.setParameter("idComment", id);

		if (!query.getResultList().isEmpty()) {
			List<Commentary> resultList = query.getResultList();
			return resultList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Find comment in table by text
	 * 
	 * @param text
	 * @return
	 */
	public Commentary getCommentByText(String text) {
		Commentary comment;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select c from Commentary c where c.commentaryBody = :text");
		query.setParameter("text", text);
		if (!query.getResultList().isEmpty()) {
			comment = (Commentary) query.getResultList().get(0);
			return comment;
		} else {
			return null;
		}
	}

	/**
	 * update body of comment
	 * 
	 * @param comment
	 * @param commentBody
	 */
	public void updateCommentBody(Commentary comment, String commentBody) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Commentary commentToEdit = em.find(Commentary.class, comment.getIdCommentary());
		commentToEdit.setCommentaryBody(commentBody);
		JpaHelper.commitTransaction();
	}

}
