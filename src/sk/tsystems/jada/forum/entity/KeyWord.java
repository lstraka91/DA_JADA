/**
 * @author Tomas Bortnak
 */

package sk.tsystems.jada.forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KeyWord {

	/**
	 * Integer variable, identifier of keyword
	 */
	private int idKeyWord;

	/**
	 * String variable, body of keyword
	 */
	private String keyWord;

	/**
	 * Implicit class constructor
	 */
	public KeyWord() {

	}

	/**
	 * Class constructor using field
	 * 
	 * @param keyWord
	 *            variable o type String
	 */
	public KeyWord(String keyWord) {
		this.keyWord = keyWord.toLowerCase();
	}

	/**
	 * Method return identifier keyword
	 * 
	 * @return idKeyWord identifier keyword
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdKeyWord() {
		return idKeyWord;
	}

	/**
	 * Sets identifier keyword by parameter
	 * 
	 * @param idKeyWord
	 *            identifier of keyword
	 */
	public void setIdKeyWord(int idKeyWord) {
		this.idKeyWord = idKeyWord;
	}

	/**
	 * Method return current keyword
	 * 
	 * @return keyWord
	 */
	public String getKeyWord() {
		return keyWord;
	}

	/**
	 * Sets current keyword by parameter
	 * 
	 * @param keyWord
	 *            variable of type String
	 */
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * Method toString
	 */
	@Override
	public String toString() {
		return "KeyWord [idKeyWord=" + idKeyWord + ", keyWord=" + keyWord + "]";
	}
}