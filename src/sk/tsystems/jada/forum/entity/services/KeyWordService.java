/**
 * @author Tomas Bortnak
 */
package sk.tsystems.jada.forum.entity.services;

import sk.tsystems.jada.forum.entity.services.JpaHelper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.KeyWord;

public class KeyWordService {

	/**
	 * Save keyword to database
	 * 
	 * @param keyWord
	 */
	private void saveKeyWord(KeyWord keyWord) {
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.beginTransaction();
		em.persist(keyWord);
		JpaHelper.commitTransaction();
	}

	/**
	 * Find keyword in database (by String), if keyword isn't in database,
	 * function save it (comment row)
	 * 
	 * @param input
	 * @return
	 */
	public KeyWord findKeyWord(String input) {
		KeyWord kw = null;
		try {
			EntityManager em = JpaHelper.getEntityManager();
			Query query = em.createQuery("SELECT k from KeyWord k WHERE k.keyWord=:input");
			query.setParameter("input", input);
			System.out.println(query.getResultList());
			kw = (KeyWord) query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("KeyWord " + input + " is not in database");
			kw = createKeyWord(input);
			saveKeyWord(kw);
		}
		return kw;
	}

	/**
	 * Helper function (create new object - keyword)
	 * 
	 * @param keyWord
	 * @return
	 */
	private KeyWord createKeyWord(String keyWord) {
		KeyWord kw = new KeyWord();
		kw.setKeyWord(keyWord);
		return kw;
	}

	/**
	 * Find id of top 10 used keywords
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> topKeyWords() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createNativeQuery(
				"select ID_KEYWORD from (select id_keyword, count(id_keyword) as pocet from topic_keyword group by ID_KEYWORD order by ID_KEYWORD desc)");
		ArrayList<Integer> result = (ArrayList<Integer>) query.setMaxResults(10).getResultList();
		return result;

	}

	@SuppressWarnings("unchecked")
	public ArrayList<KeyWord> getAllKeyWords() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select k from KeyWord k");
		ArrayList<KeyWord> resultList = (ArrayList<KeyWord>) query.getResultList();
		return resultList;
	}

}