package sk.tsystems.jada.forum.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 428108314569688804L;

	/**
	 * ident of rating
	 */
	@Id
	@GeneratedValue
	private int ident;

	/**
	 * value of rating should be 0 OR 1
	 */
	private int value;

	/**
	 * Object type ratingId that indicate composite primary key
	 */
	@EmbeddedId
	private RatingId rid;

	/**
	 * getter that return ident of rating
	 * 
	 * @return ident
	 */

	public int getIdent() {
		return ident;
	}

	/**
	 * getter that return value of rating
	 * 
	 * @return
	 */

	public int getValue() {
		return value;
	}

	/**
	 * set the value of rating
	 * 
	 * @param value
	 */

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * getter that returns object of Rating composite primary key
	 * 
	 * @return RatingId object
	 */
	public RatingId getRid() {
		return rid;
	}

	/**
	 * set the RatingId object
	 * 
	 * @param rid
	 */

	public void setRid(RatingId rid) {
		this.rid = rid;
	}

}
