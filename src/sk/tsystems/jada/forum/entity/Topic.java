package sk.tsystems.jada.forum.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.mapping.Set;

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
//	@OneToMany(mappedBy="topic")
//	private List<keyWords> listKeyWord;
	
	/**
	 * Constructor.
	 *
	 * @param String topicName
	 * @param String topicDescription
	 * @param Date topicDate
	 * @param List<keyWords> listKeyWord
	 */
	public Topic(String topicName, String topicDescription, Date topicDate/*, List<keyWords> listKeyWord*/) {
		super();
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.topicDate = topicDate;
//		this.listKeyWord = listKeyWord;
	}
	
	/**
	 * Constructor.
	 */
	public Topic(){
		
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
	 * @param int idTopic          
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
	 * @param String topicName           
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	/**
	 * Return description of topic
	 * 
	 * @return topicBody
	 */
	public String getTopictopicDescription() {
		return topicDescription;
	}

	/**
	 * Sets description of topic.
	 * 
	 * @param String topicBody          
	 */
	public void setTopictopicDescription(String topicDescription) {
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
	 * @param Date topicDate            
	 */
	public void setTopicDate(Date topicDate) {
		this.topicDate = topicDate;
	}
}
