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
	 * Method for add topic to database, with help of method getTopicByName we
	 * get name of current topic, if name is null then add topic to database
	 * 
	 * Use the {@link TopicService #getIdTopicByName(String)} method
	 * 
	 * Use the {@link Topic #getTopicName()} method
	 * 
	 * @param topic
	 *            object of Topic
	 * 
	 * @see Topic
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
	 * Method for remove topic from database by id topic, with help of method
	 * findTopicById we get identifier of current topic, if identifier is not
	 * null remove current topic
	 * 
	 * Use the {@link TopicService #findTopicById(Integer)} method
	 * 
	 * @param idTopic
	 *            identifier of current topic
	 * 
	 * @see Topic
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
	 * Person, KeyWords. With help of method findTopicById we get identifier of
	 * current topic, if identifier is not null then select all comments of
	 * current topic and then remove all comments of topic by method
	 * removeCommentByObject. Then use method removeTopicById.
	 * 
	 * Use the {@link TopicService #findTopicById(Integer)} method
	 * 
	 * Use the {@link CommentaryService #selectAllComentByTopic(Topic)} method
	 * 
	 * Use the {@link CommentaryService #removeCommentByObject(Commentary)}
	 * method
	 * 
	 * Use the {@link TopicService #removeTopicById(Integer)} method
	 * 
	 * @param idTopic
	 *            type: Integer, unique identifier of Topic {@link TopicService}
	 * 
	 * @see Commentary
	 * @see Topic
	 * @see CommentaryService
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
	 * Method for update name exist topic
	 * 
	 * Use the {@link TopicService #findTopicById(Integer)} method
	 * 
	 * Use the {@link Topic #setTopicName(String)} method
	 * 
	 * @param idTopic
	 *            identifier of current topic than we want update
	 * @param topicName
	 *            name of topic that we want update
	 * 
	 * @see Topic
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
	 * Method for update description exist topic
	 * 
	 * Use the {@link TopicService #findTopicById(Integer)} method
	 * 
	 * Use the {@link Topic #setTopicDescription(String)} method
	 * 
	 * @param idTopic
	 *            identifier of current topic than we want update
	 * @param topicDescription
	 *            description of topic that we want update
	 * 
	 * @see Topic
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

	/**
	 * Method for update name, description, keywords exist topic
	 * 
	 * Use the {@link TopicService #findTopicById(Integer)} method
	 * 
	 * Use the {@link Topic #setTopicName(String)} method
	 * 
	 * Use the {@link Topic #setTopicDescription(String)} method
	 * 
	 * Use the {@link Topic #setKeyWords(Set)} method
	 * 
	 * @param idTopic
	 *            identifier of current topic than we want update
	 * @param topicName
	 *            name of topic that we want update
	 * @param topicDescription
	 *            description of topic that we want update
	 * @param keyWords
	 *            keywords of topic that we want update
	 * 
	 * @see Topic
	 */
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
	 * @return ArrayList all topics
	 * 
	 * @see Topic
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
	 * Method for return identifier topic by topic name
	 * 
	 * @param topicName
	 *            name topic that we want identifier
	 * @return id topic identifier topic by enter topic name
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
	 * Method for return object topic by identifier topic
	 * 
	 * @param idTopic
	 *            identifier topic that we want object this topic
	 * @return topic object of type Topic
	 * 
	 * @see Topic
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
	 * Method for getting object topic by topic name
	 * 
	 * @param topicName
	 *            name topic that we want object this topic
	 * @return topic object of type Topic
	 * 
	 * @see Topic
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
	 * Use to get all topics ordered by date.
	 * 
	 * @return ArrayList of objects of class Topic, ordered by date.
	 * 
	 * @see Topic
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
	 * 
	 * @see Topic
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
	 * Method for add visitor to viewersList. If visitor visit new topic then
	 * will add to viewersList
	 * 
	 * Use the {@link TopicService #findTopicById(Integer)} method
	 * 
	 * Use the {@link Topic #getPerson()} method
	 * 
	 * Use the {@link Topic #getViewersList()} method
	 * 
	 * Use the {@link Topic #setViewersList(Set)} method
	 * 
	 * Use the {@link Topic #addViewerToList(Integer)} method
	 * 
	 * @param topic
	 *            object of type Topic
	 * @param id
	 *            identifier person
	 * 
	 * @see Topic
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
	 * Method for return all topics from enter person
	 * 
	 * @param person
	 *            object of type Person
	 * @return List of topic by person
	 * 
	 * @see Topic
	 * @see Person
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
	 * Method for return list of topic ordered by views
	 * 
	 * Use the {@link Topic #getViewersList()} method
	 * 
	 * @return ArrayList of topic ordered by views
	 * 
	 * @see Topic
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Topic> getTopicsOrderViews() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select t from Topic t");
		if (query.getResultList() != null) {
			ArrayList<Topic> resultList = (ArrayList<Topic>) query.getResultList();
			resultList.sort((t1, t2) -> t1.getViewersList().size() - t2.getViewersList().size());
			return resultList;
		} else {
			return null;
		}
	}
}
