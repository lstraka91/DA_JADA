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
	 * @param comment
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
	 * get personId
	 * 
	 * @return idPerson
	 */
	public int getIdPerson() {
		return idPerson;
	}

	/**
	 * set IdPeron
	 * 
	 * @param idPerson
	 */
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * get commentary Id
	 * 
	 * @return idCommentary
	 */
	public int getIdCommentary() {
		return idCommentary;
	}

	/**
	 * set idComment
	 * 
	 * @param idCommentary
	 */
	public void setIdCommentary(int idCommentary) {
		this.idCommentary = idCommentary;
	}

}
