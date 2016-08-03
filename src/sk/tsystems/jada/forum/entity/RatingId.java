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
	 * int of commentary id
	 */
	private Integer idCommentary;
	
	/**
	 * int of person id
	 */
	private int idPerson;


/**
 * get personId
 * @return idPerson
 */
	public int getIdPerson() {
		return idPerson;
	}

	/**
	 * set IdPeron
	 * @param idPerson
	 */
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	/**
	 * get commentary Id
	 * @return idCommentary
	 */
	public Integer getIdCommentary() {
		return idCommentary;
	}
	
	/**
	 * set idComment
	 * @param idCommentary
	 */
	public void setIdCommentary(Integer idCommentary) {
		this.idCommentary = idCommentary;
	}

}
