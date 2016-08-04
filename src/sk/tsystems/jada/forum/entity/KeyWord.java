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

	private int idKeyWord;

	private String keyWord;

	public KeyWord() {

	}

	public KeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

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
		this.keyWord = keyWord.toLowerCase();
	}
	
	@Override
	public String toString() {
		return "KeyWordEntity [id=" + idKeyWord + ", name=" + keyWord;
	}

}