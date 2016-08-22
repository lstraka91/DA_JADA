package sk.tsystems.jada.forum.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Database entity for comment
 */
@Entity
public class Commentary {

	/**
	 * identifier of comment
	 */
	@Id
	@GeneratedValue
	public int idCommentary;

	/**
	 * Body of commentary
	 */
	public String commentaryBody;

	/**
	 * Added comment date
	 */
	public Date commentaryDate;

	/**
	 * Person who commented topic
	 * 
	 * @see Person
	 */
	@ManyToOne(cascade = CascadeType.DETACH)
	public Person person;

	/**
	 * Topic object for identity whose topic was commented
	 * 
	 * @see Topic
	 */
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Topic topic;

	/**
	 * Default constructor without parameters
	 */
	public Commentary() {

	}

	/**
	 * Constructor for object Commentary
	 * 
	 * @param commentaryBody
	 *            body of current comment
	 * @param person
	 *            object of type Person for identity who added topic
	 * @param topic
	 *            object of type Topic for identity whose topic was commented
	 * 
	 * @see Person
	 * @see Topic
	 */
	public Commentary(String commentaryBody, Person person, Topic topic) {
		this.commentaryBody = commentaryBody;
		this.commentaryDate = new Date(System.currentTimeMillis());
		this.person = person;
		this.topic = topic;
	}

	/**
	 * Return identifier of current comment
	 * 
	 * @return idCommentary of comment
	 */
	public int getIdCommentary() {
		return idCommentary;
	}

	/**
	 * Sets identifier of current comment
	 * 
	 * @param idCommentary
	 *            identifier of comment
	 */
	public void setIdCommentary(int idCommentary) {
		this.idCommentary = idCommentary;
	}

	/**
	 * Return commentary body of current comment
	 * 
	 * @return commentaryBody of comment
	 */
	public String getCommentaryBody() {
		return commentaryBody;
	}

	/**
	 * Sets body of current comment
	 * 
	 * @param commentaryBody
	 *            body of comment
	 */
	public void setCommentaryBody(String commentaryBody) {
		this.commentaryBody = commentaryBody;
	}

	/**
	 * Return date added comment
	 * 
	 * @return commentaryDate of comment
	 * 
	 * @see Date
	 */
	public Date getCommentaryDate() {
		return commentaryDate;
	}

	/**
	 * Sets date added comment
	 * 
	 * @param commentaryDate
	 *            date when was comment added
	 *
	 * @see Date
	 */
	public void setCommentaryDate(Date commentaryDate) {
		this.commentaryDate = commentaryDate;
	}

	/**
	 * Return person who added current comment
	 * 
	 * @return person who add comment
	 * 
	 * @see Person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * Sets person who added current comment
	 * 
	 * @param person
	 *            who add commend
	 * 
	 * @see Person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * Return topic has current comment
	 * 
	 * @return topic whose was comment
	 * 
	 * @see Topic
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * Sets topic whose was commented
	 * 
	 * @param topic
	 *            whose topic was comment added
	 * 
	 * @see Topic
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/**
	 * Method toString
	 */
	@Override
	public String toString() {
		return "Commentary [idCommentary=" + idCommentary + ", commentaryBody=" + commentaryBody + ", commentaryDate="
				+ commentaryDate + ", person=" + person + ", topic=" + topic + "]";
	}
}
