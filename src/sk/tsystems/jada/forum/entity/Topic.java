package sk.tsystems.jada.forum.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import sk.tsystems.jada.forum.entity.services.CommentaryService;

/**
 * 
 * @author Jozef
 *
 *Database entity for topic
 */
@Entity
public class Topic {

	/**
	 * Identifier of topic
	 */
	private int idTopic;

	/**
	 * Name of topic
	 */
	@Column(unique = true)
	private String topicName;

	/**
	 * Topic body, description of topic
	 */
	private String topicDescription;

	/**
	 * Date added topic
	 */
	private Date topicDate;

	/**
	 * List of keywords
	 * 
	 * @see KeyWord
	 */
	private Set<KeyWord> keyWords;

	/**
	 * Person who update topic
	 * 
	 * @see Person
	 */
	private Person person;

	/**
	 * Stores identifiers of users which visited this topic.
	 */
	private Set<Integer> viewersList;

	/**
	 * Constructor for object topic without parameter
	 * 
	 * @see KeyWord
	 */
	public Topic() {
		this.keyWords = null;
	}

	/**
	 * Constructor for object topic
	 * 
	 * @param topicName
	 *            name of current topic
	 * @param topicDescription
	 *            description of current topic
	 * @param keyWords
	 *            set keywords for description current topic
	 * @param person
	 *            object of type Person for identity who added topic
	 * 
	 * @see Person
	 * @see KeyWord
	 */
	public Topic(String topicName, String topicDescription, Set<KeyWord> keyWords, Person person) {
		super();
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.topicDate = new Date(System.currentTimeMillis());
		this.keyWords = keyWords;
		this.person = person;
		this.viewersList = new HashSet<Integer>();
	}

	/**
	 * Method that return count comments of current topic
	 * 
	 * @return count comments
	 * 
	 * @see Commentary
	 */
	@Transient
	public int getNumberOfComments() {
		List<Commentary> commentsList = new CommentaryService().selectAllComentByTopic(this);
		if (commentsList != null) {
			return commentsList.size();
		} else {
			return 0;
		}
	}

	/**
	 * Method that return count views of current topic
	 * 
	 * @return count views
	 */
	@Transient
	public int getNumberOfViews() {
		if (viewersList != null) {
			return viewersList.size();
		} else {
			return 0;
		}
	}

	/**
	 * Return identifier of current topic
	 * 
	 * @return idTopic of topic
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdTopic() {
		return idTopic;
	}

	/**
	 * Sets identifier of current topic.
	 * 
	 * @param idTopic
	 *            identifier of topic
	 */
	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}

	/**
	 * Return name of current topic
	 * 
	 * @return topicName of topic
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * Sets name of current topic
	 * 
	 * @param topicName
	 *            name of topic
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	/**
	 * Return description of current topic
	 * 
	 * @return topicDescription of topic
	 */
	public String getTopicDescription() {
		return topicDescription;
	}

	/**
	 * Sets description of current topic
	 * 
	 * @param topicDescription
	 *            description of topic
	 */
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	/**
	 * Return date added topic
	 * 
	 * @return topicDate of topic
	 * 
	 * @see Date
	 */
	public Date getTopicDate() {
		return topicDate;
	}

	/**
	 * Sets date added topic.
	 * 
	 * @param topicDate
	 *            date when was topic added
	 * 
	 * @see Date
	 */
	public void setTopicDate(Date topicDate) {
		this.topicDate = topicDate;
	}
	
	/**
	 * Return person who added current topic
	 * 
	 * @return person who add topic
	 * 
	 * @see Person
	 */
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets person who added current topic
	 * 
	 * @param person
	 *            who add topic
	 * 
	 * @see Person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Return set keywords of current topic
	 * 
	 * @return set identifier keywords to relevant identifier topic
	 * 
	 * @see KeyWord
	 */
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinTable(name = "topic_keyword", joinColumns = @JoinColumn(name = "id_topic"), inverseJoinColumns = @JoinColumn(name = "id_keyWord"))
	public Set<KeyWord> getKeyWords() {
		return keyWords;
	}

	/**
	 * Sets keywords for current topic
	 * 
	 * @param keywords
	 *            set keywords for current topic
	 * 
	 * @see KeyWord
	 */
	public void setKeyWords(Set<KeyWord> keywords) {
		this.keyWords = keywords;
	}

	/**
	 * Add user to viewers list by identifier user
	 * 
	 * @param idOfUser
	 *            identifier user who visit current topic
	 */
	public void addViewerToList(Integer idOfUser) {
		this.viewersList.add(idOfUser);
	}

	/**
	 * Return count visit of current topic
	 * 
	 * @return viewersList return count visit of current topic
	 */
	@Column
	@ElementCollection(targetClass = Integer.class)
	public Set<Integer> getViewersList() {
		return viewersList;
	}

	/**
	 * Set viewers list of current topic
	 * 
	 * @param viewersList
	 *            increment count visit if new user visit current topic
	 */
	public void setViewersList(Set<Integer> viewersList) {
		this.viewersList = viewersList;
	}

	/**
	 * Method toString
	 */
	@Override
	public String toString() {
		return "Topic [idTopic=" + idTopic + ", topicName=" + topicName + ", topicDescription=" + topicDescription
				+ ", topicDate=" + topicDate + ", keyWords=" + keyWords + ", person=" + person + ", viewersList="
				+ viewersList + "]";
	}

}
