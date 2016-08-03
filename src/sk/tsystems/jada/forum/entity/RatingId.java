package sk.tsystems.jada.forum.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RatingId implements Serializable{

	/**
	 * auto generated serialUID
	 */
	private static final long serialVersionUID = -5416666417570281293L;

	/**
	 * Object that indicate comment to which was rating applied
	 */
	private Commentary comment;
	
	/**
	 * Object that indicate person who rate the comment
	 */
	private Person person;

	/**
	 * getter method that returns Commentary object
	 * 
	 * @return comment
	 */
	
	public Commentary getComment() {
		return comment;
	}

	/**
	 * set the comment object
	 * 
	 * @param comment
	 */
	public void setComment(Commentary comment) {
		this.comment = comment;
	}

	/**
	 * getter method that return Person object
	 * 
	 * @return person
	 */
	
	public Person getPerson() {
		return person;
	}

	/**
	 * set the user object
	 * 
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}
