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
	public void removeTopicByObject(Topic topic) {
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
	public void removeTopicById(int id) {
		Topic topic = new Topic();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, id);
		em.remove(topic);
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for update topic name
	 * 
	 * @param topic
	 */
	public void updateTopicName(Topic topic, String topicName) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, topic);
		topic.setTopicName(topicName);
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for update topic description
	 * 
	 * @param topic
	 */
	public void updateTopicDescrition(Topic topic, String topicDescription) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = em.find(Topic.class, topic);
		topic.setTopicDescription(topicDescription);
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
		return (ArrayList<Topic>)query.getResultList();
		
	}
}
