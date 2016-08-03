package sk.tsystems.jada.forum.entity.services;

import java.util.List;

import javax.persistence.EntityManager;


import sk.tsystems.jada.forum.entity.Commentary;



public class CommentaryService {

	
	public void addComent(Commentary comment) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(comment);
		JpaHelper.commitTransaction();
	}
	
	public void removeCommentById(int id){
		Commentary comment = new Commentary();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		comment=em.find(Commentary.class,id);
		em.remove(comment);
		JpaHelper.commitTransaction();
	}
	
	public void removeCommentByObject(Commentary comment){
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		comment=em.find(Commentary.class,comment);
		em.remove(comment);
		JpaHelper.commitTransaction();
	}
	
	
	public List<Commentary> selectAllComent() {
		
		
			JpaHelper.beginTransaction();
			EntityManager em = JpaHelper.getEntityManager();
			JpaHelper.commitTransaction();
			List<Commentary> list  = em.createQuery("SELECT c FROM CommentJPA c where c.game.gameID = '' ").getResultList();

			return list;
		}
	
	public List<Commentary> selectAllComentByTopic() {
		
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();
		List<Commentary> list  = em.createQuery("SELECT c FROM CommentJPA c where c.game.gameID = '' ").getResultList();

		return list;
	}
	
	public List<Commentary> selectAllComentByPerson() {
		
		
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.commitTransaction();
		List<Commentary> list  = em.createQuery("SELECT c FROM CommentJPA c where c.game.gameID = '' ").getResultList();

		return list;
	}
	
	
	
}
