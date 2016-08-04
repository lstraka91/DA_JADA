package sk.tsystems.jada.forum.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import sk.tsystems.jada.forum.entity.services.PersonService;

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

	public Rating(int rate, Person person, Commentary commentary) {

		// initialize ratingID compostite Primary Keys
		RatingId ratingIdPK = new RatingId(person, commentary);
		this.ratingIdCompositePK = ratingIdPK;
		this.rate = rate;

	}

	/**
	 * getter that return ident of rating
	 * 
	 * @return idRating
	 */

	public int getIdRating() {
		return idRating;
	}

	/**
	 * getter that return value of rating
	 * 
	 * @return rate
	 */

	public int getRate() {
		return rate;
	}

	/**
	 * set the value of rating
	 * 
	 * @param rate
	 */

	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * getter that returns object of Rating composite primary key
	 * 
	 * @return RatingId object
	 */
	public RatingId getRatingIdCompositePK() {
		return ratingIdCompositePK;
	}

	/**
	 * set the RatingId object
	 * 
	 * @param rid
	 */
	public void setRatingIdCompositePK(RatingId ratingIdCompositePK) {
		this.ratingIdCompositePK = ratingIdCompositePK;
	}

}