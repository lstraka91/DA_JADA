package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Topic;

public class TopicService {

	/**
	 * Method for add topic to database
	 * 
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		String topicName = topic.getTopicName();
		int idTopic = getIdTopicByName(topicName);
		if (idTopic == 0) {
			JpaHelper.beginTransaction();
			EntityManager em = JpaHelper.getEntityManager();
			em.persist(topic);
			JpaHelper.commitTransaction();
		}
	}

	/**
	 * Method for remove topic from database by id topic
	 * 
	 * @param id
	 */
	public void removeTopicById(int idTopic) {
		Topic topic = new Topic();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, idTopic);
		if (topic != null) {
			em.remove(topic);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for update topic name
	 * 
	 * @param idTopic, topicName
	 */
	public void updateTopicName(int idTopic, String topicName) {
		Topic topic = new Topic();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, idTopic);
		if (topic != null) {
			topic.setTopicName(topicName);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for update topic description
	 * 
	 * @param idTopic, topicDescription
	 */
	public void updateTopicDescrition(int idTopic, String topicDescription) {
		Topic topic = new Topic();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, idTopic);
		if (topic != null) {
			topic.setTopicDescription(topicDescription);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for select all topics from database
	 * 
	 * @return
	 * 
	 */
	public ArrayList<Topic> showTopics() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select t from Topic t");
		return (ArrayList<Topic>) query.getResultList();
	}

	/**
	 * Method for return id topic by topic name
	 * 
	 * @param topicName
	 * @return id topic
	 */
	public int getIdTopicByName(String topicName) {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT idTopic FROM Topic t WHERE t.topicName=:topicName");
		query.setParameter("topicName", topicName);
		if (query.getResultList().isEmpty()) {
			return 0;
		} else {
			return (int) query.getResultList().get(0);
		}
	}
	
	/**
	 * Method for return topic by id topic
	 * 
	 * @param idTopic
	 * @return topic
	 */
	public Topic findTopicById(int idTopic){
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT t FROM Topic t WHERE t.idTopic=:idTopic");
		query.setParameter("idTopic", idTopic);
		if (query.getResultList().isEmpty()) {
			return null;
		} else {
			return (Topic) query.getResultList().get(0);
		}
	}
}
