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
	 * 
	 */
	public void removeCommentByObject(Commentary comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		comment = em.find(Commentary.class, comment);
		em.remove(comment);
		JpaHelper.commitTransaction();
	}
	
	/**
	 * Select Commentary object from Database by id of COmment
	 * @param id
	 * @return return Commentary object or null if select failed and have no result for the current Id
	 */
	@SuppressWarnings("unchecked")
	public Commentary selectCommentById(int id){
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

}
