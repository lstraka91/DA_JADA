package sk.tsystems.jada.forum.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Topic {

	/**
	 * Identifier of topic
	 */
	private int idTopic;

	/**
	 * Name of topic
	 */
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
	 * Constructor.
	 */
	public Topic() {

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
	public Set<KeyWord> getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(Set<KeyWord> keywords) {
		this.keyWords = keywords;
	}

}
