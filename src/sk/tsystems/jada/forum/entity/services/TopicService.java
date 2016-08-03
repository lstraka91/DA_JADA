package sk.tsystems.jada.forum.entity.services;

import javax.persistence.EntityManager;

import sk.tsystems.jada.forum.entity.Topic;

public class TopicService {

	/**
	 * Method for add topic to database
	 * 
	 * @param topic
	 */
	public void addTopic(Topic topic){
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(topic);
		JpaHelper.commitTransaction();
	}
	
	/**
	 * Method for remove topic from database by object topic
	 * 
	 * @param topic
	 */
	public void removeTopicByObject(Topic topic){
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, topic);
		em.remove(topic);
		JpaHelper.commitTransaction();
	}
	
	/**
	 * Method for remove topic from database by id topic
	 * 
	 * @param id
	 */
	public void removeTopicById(int id){
		Topic topic = new Topic();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, id);
		em.remove(topic);
		JpaHelper.commitTransaction();
	}
}
