package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.KeyWord;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;

public class TopicService {

	/**
	 * Method for add topic to database
	 * 
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		String topicName = topic.getTopicName();
		Topic testTopic = getTopicByName(topicName);
		if (testTopic == null) {
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
	private void removeTopicById(int idTopic) {
		Topic topic = null;
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		topic = findTopicById(idTopic);
		if (topic != null) {
			em.remove(topic);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Removes object of topic with all comments, keeps references of objects
	 * Person, KeyWords.
	 * 
	 * @param idTopic
	 *            type: Integer, unique identifier of Topic {@link TopicService}
	 * 
	 */
	public void removeTopicByIdChecked(int idTopic) {
		CommentaryService cs = new CommentaryService();

		Topic topic = findTopicById(idTopic);
		if (topic != null) {
			List<Commentary> commentList = new ArrayList<>();
			commentList = cs.selectAllComentByTopic(topic);

			if (commentList != null) {
				if (!commentList.isEmpty()) {
					for (Commentary com : commentList) {
						cs.removeCommentByObject(com);
					}
				}
			}
			removeTopicById(idTopic);
		}
	}

	/**
	 * Method for update topic name
	 * 
	 * @param idTopic,
	 *            topicName
	 */
	public void updateTopicName(int idTopic, String topicName) {
		Topic topic = null;
		JpaHelper.beginTransaction();
		topic = findTopicById(idTopic);
		if (topic != null) {
			topic.setTopicName(topicName);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for update topic description
	 * 
	 * @param idTopic,
	 *            topicDescription
	 */
	public void updateTopicDescrition(int idTopic, String topicDescription) {
		Topic topic = null;
		JpaHelper.beginTransaction();
		topic = findTopicById(idTopic);
		if (topic != null) {
			topic.setTopicDescription(topicDescription);
		}
		JpaHelper.commitTransaction();
	}

	public void updateTopic(int idTopic, String topicName, String topicDescription, Set<KeyWord> keyWords) {
		Topic topic = null;
		JpaHelper.beginTransaction();
		topic = findTopicById(idTopic);
		if (topic != null) {
			topic.setTopicName(topicName);
			topic.setTopicDescription(topicDescription);
			topic.setKeyWords(keyWords);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method for select all topics from database
	 * 
	 * @return
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Topic> getAllTopics() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select t from Topic t");
		if (query.getResultList() != null) {
			ArrayList<Topic> resultList = (ArrayList<Topic>) query.getResultList();
			return resultList;
		} else {
			return null;
		}
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
	public Topic findTopicById(int idTopic) {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT t FROM Topic t WHERE t.idTopic=:idTopic");
		query.setParameter("idTopic", idTopic);
		if (query.getResultList().isEmpty()) {
			return null;
		} else {
			return (Topic) query.getResultList().get(0);
		}
	}

	/**
	 * Method for getting topic by topic name
	 * 
	 * @param topicName
	 * @return
	 */
	private Topic getTopicByName(String topicName) {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT t FROM Topic t WHERE t.topicName=:topicName");
		query.setParameter("topicName", topicName);
		if (query.getResultList().isEmpty()) {
			return null;
		} else {
			return (Topic) query.getResultList().get(0);
		}
	}

	/**
	 * Use to get topics ordered by date.
	 * 
	 * @return ArrayList of objects of class Topic, ordered by date.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Topic> getTopicsOrderDate() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select t from Topic t order by t.topicDate desc");
		if (query.getResultList() != null) {
			ArrayList<Topic> resultList = (ArrayList<Topic>) query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	/**
	 * Use to get all commented topics in descending order depending on amount
	 * of comments.
	 * 
	 * @return ArrayList of objects of class Topic, which have been commented at
	 *         least once.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Topic> getTopicsOrderComments() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createNativeQuery(
				"select * from Topic t where t.idtopic in (select topic_idtopic from (select topic_idtopic, count(*) as commentsNumber from Commentary group by topic_idtopic order by commentsNumber desc))",
				Topic.class);
		if (query.getResultList() != null) {
			ArrayList<Topic> resultList = (ArrayList<Topic>) query.getResultList();

			return resultList;
		} else {
			return null;
		}
	}

	/**
	 * @param topic
	 * @param id
	 */
	public void addVisitorToTopic(Topic topic, Integer id) {
		JpaHelper.beginTransaction();
		Topic existingTopic = findTopicById(topic.getIdTopic());
		if (existingTopic.getPerson().getIdPerson() == id) {
			return;
		}
		if (existingTopic != null) {
			if (existingTopic.getViewersList() == null) {
				existingTopic.setViewersList(new HashSet<>());
			}
			if (!existingTopic.getViewersList().contains(id)) {
				existingTopic.addViewerToList(id);
				JpaHelper.commitTransaction();
			}
		}
	}

	/**
	 * @param person
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Topic> selectAllTopicsByPerson(Person person) {

		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT t FROM Topic t where t.person.idPerson = :idPerson ");
		query.setParameter("idPerson", person.getIdPerson());

		if (!query.getResultList().isEmpty()) {
			List<Topic> resultList = query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Topic> getTopicsOrderViews() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select t from Topic t");
		if (query.getResultList() != null) {
			ArrayList<Topic> resultList = (ArrayList<Topic>) query.getResultList();
			resultList.sort((t1, t2) -> t1.getViewersList().size() - t2.getViewersList().size());
			// Collections.reverse(resultList);
			return resultList;
		} else {
			return null;
		}
	}

}
