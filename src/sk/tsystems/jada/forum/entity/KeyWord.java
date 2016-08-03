/**
 * @author Tomas Bortnak
 */

package sk.tsystems.jada.forum.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class KeyWord {

	@Id
	@GeneratedValue
	private int idKeyWord;

	private String keyWord;

	private Set<Topic> topics;

	public KeyWord() {

	}

	public KeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

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

    @ManyToMany(mappedBy = "keywords")
	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	
	

}