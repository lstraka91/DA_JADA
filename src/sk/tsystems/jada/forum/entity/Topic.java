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
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import sk.tsystems.jada.forum.entity.services.CommentaryService;

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
	 */
	private Set<KeyWord> keyWords;

	/**
	 * Person who update topic
	 */
	private Person person;

	/**
	 * Stores ids of users which visited this topic.
	 */
	private Set<Integer> viewersList;

	/**
	 * Constructor.
	 */
	public Topic() {
		this.keyWords = null;
	}

	/**
	 * Constructor.
	 * 
	 * @param topicName
	 * @param topicDescription
	 * @param keyWords
	 * @param person
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

	@Transient
	public int getNumberOfComments() {
		List<Commentary> commentsList = new CommentaryService().selectAllComentByTopic(this);
		if (commentsList != null) {
			return commentsList.size();
		} else {
			return 0;
		}
	}

	@Transient
	public int getNumberOfViews() {
		if (viewersList != null) {
			return viewersList.size();
		} else {
			return 0;
		}
	}

	/**
	 * Return id topic
	 * 
	 * @return idTopic
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdTopic() {
		return idTopic;
	}

	/**
	 * Sets identifier of topic.
	 * 
	 * @param idTopic
	 */
	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}

	/**
	 * Return topic name
	 * 
	 * @return topicName
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * Sets name of topic
	 * 
	 * @param topicName
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	/**
	 * Return description of topic
	 * 
	 * @return topicBody
	 */
	public String getTopicDescription() {
		return topicDescription;
	}

	/**
	 * Sets description of topic.
	 * 
	 * @param topicDescription
	 */
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	/**
	 * Return date added topic
	 * 
	 * @return topicDate
	 */
	public Date getTopicDate() {
		return topicDate;
	}

	/**
	 * Sets date added topic.
	 * 
	 * @param topicDate
	 */
	public void setTopicDate(Date topicDate) {
		this.topicDate = topicDate;
	}

	/**
	 * Return person
	 * 
	 * @return person
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets person.
	 * 
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "topic_keyword", joinColumns = @JoinColumn(name = "id_topic"), inverseJoinColumns = @JoinColumn(name = "id_keyWord"))
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	public Set<KeyWord> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(Set<KeyWord> keywords) {
		this.keyWords = keywords;
	}

	public void addViewerToList(Integer idOfUser) {
		this.viewersList.add(idOfUser);
	}

	@Column
	@OneToMany
	@ElementCollection(targetClass = Integer.class)
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Set<Integer> getViewersList() {
		return viewersList;
	}

	public void setViewersList(Set<Integer> viewersList) {
		this.viewersList = viewersList;
	}

	@Override
	public String toString() {
		return "Topic [idTopic=" + idTopic + ", topicName=" + topicName + ", topicDescription=" + topicDescription
				+ ", topicDate=" + topicDate + ", keyWords=" + keyWords + ", person=" + person + ", viewersList="
				+ viewersList + "]";
	}

}
