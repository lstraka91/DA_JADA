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
	 * Comment identifier
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
	 * User object
	 */
	@ManyToOne(cascade = CascadeType.DETACH)
	public Person person;

	/**
	 * Topic object
	 */
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Topic topic;

	/**
	 * Default constructor
	 */
	public Commentary() {

	}

	/**
	 * 
	 * @param commentaryBody
	 * @param commentaryDate
	 * @param person
	 * @param topic
	 */
	public Commentary(String commentaryBody, Person person, Topic topic) {
		this.commentaryBody = commentaryBody;
		this.commentaryDate = new Date(System.currentTimeMillis());
		this.person = person;
		this.topic = topic;
	}

	/**
	 * Getters
	 */
	public int getIdCommentary() {
		return idCommentary;
	}

	public String getCommentaryBody() {
		return commentaryBody;
	}

	public Date getCommentaryDate() {
		return commentaryDate;
	}

	public Person getPerson() {
		return person;
	}

	public Topic getTopic() {
		return topic;
	}

	/**
	 * Setters
	 */

	public void setIdCommentary(int idCommentary) {
		this.idCommentary = idCommentary;
	}

	public void setCommentaryBody(String commentaryBody) {
		this.commentaryBody = commentaryBody;
	}

	public void setCommentaryDate(Date commentaryDate) {
		this.commentaryDate = commentaryDate;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Commentary [idCommentary=" + idCommentary + ", commentaryBody=" + commentaryBody + ", commentaryDate="
				+ commentaryDate + ", person=" + person + ", topic=" + topic + "]";
	}

}
