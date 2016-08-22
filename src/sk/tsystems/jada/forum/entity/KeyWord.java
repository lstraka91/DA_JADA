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
	 * Integer variable, id of keyword
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
	 * Class constructor.
	 * 
	 * @param keyWord
	 */
	public KeyWord(String keyWord) {
		this.keyWord = keyWord.toLowerCase();
	}

	/*** Getters and Setters ***/

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdKeyWord() {
		return idKeyWord;
	}

	public void setIdKeyWord(int idKeyWord) {
		this.idKeyWord = idKeyWord;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return "KeyWord [idKeyWord=" + idKeyWord + ", keyWord=" + keyWord + "]";
	}

}