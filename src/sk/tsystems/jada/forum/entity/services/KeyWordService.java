/**
 * @author Tomas Bortnak
 */
package sk.tsystems.jada.forum.entity.services;

import sk.tsystems.jada.forum.entity.services.JpaHelper;
import javax.persistence.EntityManager;
import sk.tsystems.jada.forum.entity.KeyWord;

public class KeyWordService {

	/**
	 * Save keyword  to database
	 * 
	 * @param keyWord
	 */
	public void saveKeyWord(KeyWord keyWord) {
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.beginTransaction();
		em.persist(keyWord);
		JpaHelper.commitTransaction();
	}

	/**
	 * Find keyword in database (by String),  
	 * if keyword isn't in database, function save it (comment row)
	 * 
	 * @param input
	 * @return
	 */
	public KeyWord findKeyWord(String input) {
		KeyWord kw = null;
		try {
			EntityManager em = JpaHelper.getEntityManager();
			javax.persistence.Query query = em.createQuery("SELECT k from KeyWord k WHERE k.keyWord=:input");
			query.setParameter("input", input);
			System.out.println(query.getResultList());
			kw = (KeyWord) query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			System.out.println("Your keyWord is not in database");
			saveKeyWord(createKeyWord(input));
		}
		return kw;
	}

	/**
	 * Helper function
	 * (create new object - keyword)
	 * 
	 * @param keyWord
	 * @return
	 */
	public KeyWord createKeyWord(String keyWord) {
		KeyWord kw = new KeyWord();
		kw.setKeyWord(keyWord);
		return kw;
	}

}