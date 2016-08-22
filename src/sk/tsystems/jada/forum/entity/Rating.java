package sk.tsystems.jada.forum.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ratinggg")
public class Rating implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 428108314569688804L;

	/**
	 * rating id
	 */
	@Id
	@GeneratedValue
	private int idRating;

	/**
	 * value of rating should be 0 OR 1
	 */
	private int rate;

	/**
	 * Object type ratingId that indicate composite primary key
	 */
	@EmbeddedId
	private RatingId ratingIdCompositePK;

	/**
	 * Constructor for object Rating, returns an object of Person that add
	 * rating and Comment to what rating was added
	 * 
	 * @param rate
	 *            value of rating for current Comment
	 * @param person
	 *            Object of type Person, to identify who add rating
	 * @param commentary
	 *            object of type Comment to identify to which comment was rating
	 *            added
	 * @see Person
	 * @see Commentary
	 */
	public Rating(int rate, Person person, Commentary commentary) {

		// initialize ratingID compostite Primary Keys
		RatingId ratingIdPK = new RatingId(person, commentary);
		this.ratingIdCompositePK = ratingIdPK;
		this.rate = rate;

	}

	/**
	 * Constructor without parameters
	 */
	public Rating() {

	}

	/**
	 * return ident of rating
	 * 
	 * @return idRating id of comment
	 */

	public int getIdRating() {
		return idRating;
	}

	/**
	 * return value of rating
	 * 
	 * @return rate value of rate
	 */

	public int getRate() {
		return rate;
	}

	/**
	 * set the value of rating
	 * 
	 * @param rate
	 *            value of rate
	 */

	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * returns object of Rating composite primary key
	 * 
	 * @return RatingId object that consist of Person and Comment reference by
	 *         id of both Objects
	 */
	public RatingId getRatingIdCompositePK() {
		return ratingIdCompositePK;
	}

	/**
	 * set the RatingId object
	 * 
	 * @param ratingIdCompositePK
	 *            set the object of ratingId primary key that consist of
	 *            reference to another objects Person and Comment
	 */
	public void setRatingIdCompositePK(RatingId ratingIdCompositePK) {
		this.ratingIdCompositePK = ratingIdCompositePK;
	}

}