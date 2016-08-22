package sk.tsystems.jada.forum.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RatingId implements Serializable {

	/**
	 * auto generated serialUID
	 */
	private static final long serialVersionUID = -5416666417570281293L;

	/**
	 * int of commentary id
	 */
	private int idCommentary;

	/**
	 * int of person id
	 */
	private int idPerson;

	/**
	 * Constructor that initialize personId and commentId
	 * 
	 * @param person
	 *            Object of type Person that represent who add rating
	 * @param comment
	 *            Object of type Comment that represent to which comment is
	 *            rating added
	 * @see Person
	 * @see Commentary
	 * 
	 */
	public RatingId(Person person, Commentary comment) {
		this.idCommentary = comment.getIdCommentary();
		this.idPerson = person.getIdPerson();
	}

	/**
	 * default constructor without parameters
	 */
	public RatingId() {

	}

	/**
	 * return personId
	 * 
	 * @return idPerson identification number of User
	 */
	public int getIdPerson() {
		return idPerson;
	}

	/**
	 * set IdPeron
	 * 
	 * @param idPerson
	 *            identification number of User object
	 * @see Person
	 */
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * return commentary Id
	 * 
	 * @return idCommentary identification number of comment object
	 * @see Commentary
	 */
	public int getIdCommentary() {
		return idCommentary;
	}

	/**
	 * set idComment
	 * 
	 * @param idCommentary
	 *            value of id for Commentary object
	 */
	public void setIdCommentary(int idCommentary) {
		this.idCommentary = idCommentary;
	}

}
