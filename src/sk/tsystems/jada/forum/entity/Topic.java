package sk.tsystems.jada.forum.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {

	/**
	 * Identifier of topic
	 */
	@Id
	@GeneratedValue
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
	private Date topicDate = new Date(System.currentTimeMillis());

	/**
	 * List of keywords
	 */
	@OneToMany(mappedBy = "topic")
	private List<KeyWords> listKeyWord;

	/**
	 * Person who update topic
	 */
	@OneToMany
	private Person person;

	/**
	 * Constructor.
	 *
	 * @param String
	 *            topicName
	 * @param String
	 *            topicDescription
	 * @param Date
	 *            topicDate
	 * @param List<keyWords>
	 *            listKeyWord
	 */
	public Topic(String topicName, String topicDescription, Date topicDate, Person person, List<KeyWords> listKeyWord) {
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.topicDate = topicDate;
		this.person = person;
		this.listKeyWord = listKeyWord;
	}

	/**
	 * Constructor.
	 */
	public Topic() {

	}

	/**
	 * Return id topic
	 * 
	 * @return idTopic
	 */
	public int getIdTopic() {
		return idTopic;
	}

	/**
	 * Sets identifier of topic.
	 * 
	 * @param int
	 *            idTopic
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
	 * @param String
	 *            topicName
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
	 * @param String
	 *            topicBody
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
	 * @param Date
	 *            topicDate
	 */
	public void setTopicDate(Date topicDate) {
		this.topicDate = topicDate;
	}

	/**
	 * Return list of keywords
	 * 
	 * @return listKeyWord
	 */
	public List<KeyWords> getListKeyWord() {
		return listKeyWord;
	}

	/**
	 * Sets list keywords.
	 * 
	 * @param List<KeyWords>
	 *            listKeyWord
	 */
	public void setListKeyWord(List<KeyWords> listKeyWord) {
		this.listKeyWord = listKeyWord;
	}

	/**
	 * Return person
	 * 
	 * @return person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets person.
	 * 
	 * @param Person person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}
