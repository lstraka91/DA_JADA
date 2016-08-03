package sk.tsystems.jada.forum.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
public	Integer idCommentary;

/** 
 * Body of commentary
 */
public	String commentaryBody;

/** 
 * Added comment date
 */
public	Date commentaryDate;

/** 
 * User object
 */
@ManyToOne
public Person person;


/** 
 * Topic object
 */
@ManyToOne
public Topic topic;


/**
 * Default constructor
 */
public Commentary() {
	
}


/**
 * 
 * @param idCommentary
 * @param commentaryBody
 * @param commentaryDate
 * @param person
 * @param topic
 */
public Commentary(Integer idCommentary, String commentaryBody, Date commentaryDate, Person person, Topic topic) {
	super();
	this.idCommentary = idCommentary;
	this.commentaryBody = commentaryBody;
	this.commentaryDate = commentaryDate;
	this.person = person;
	this.topic = topic;
}


/** 
 * Getters
 */
public Integer getIdCommentary() {
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

public void setIdCommentary(Integer idCommentary) {
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



}
