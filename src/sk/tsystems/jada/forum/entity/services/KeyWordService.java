/**
 * @author Tomas Bortnak
 */
package sk.tsystems.jada.forum.entity.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.KeyWord;

public class KeyWordService {

	/**
	 * Save keyword to database
	 * 
	 * @param keyWord
	 *            object of type KeyWord
	 * 
	 * @see KeyWord
	 */
	private void saveKeyWord(KeyWord keyWord) {
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.beginTransaction();
		em.persist(keyWord);
		JpaHelper.commitTransaction();
	}

	/**
	 * Method finds keyword in database (by String), if keyword isn't in
	 * database, function save it. Function have to connect to the database and
	 * try to find object of type keyword by String that is passed to this
	 * method by parameter. If keyword from parameter is in database, Method
	 * return object of type keyWord where body of keyWord is the same as
	 * parameter. Where this object isn't in database, method create new object
	 * and save it to database.
	 * 
	 * @param input
	 *            String, method check if this String is in database, if not,
	 *            method save it.
	 * 
	 * @return kw is object of type keyword. This object contains id of
	 *         keyword(integer) and keyWord(String)
	 * 
	 * @see KeyWord
	 */
	public KeyWord findKeyWord(String input) {
		KeyWord kw;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("SELECT k from KeyWord k WHERE k.keyWord=:input");
		query.setParameter("input", input);
		if (!query.getResultList().isEmpty()) {
			kw = (KeyWord) query.getResultList().get(0);
		} else {
			kw = new KeyWord(input);
			saveKeyWord(kw);
		}
		return kw;
	}

	/**
	 * Function have to connect to the database and try to find most used
	 * keyWords from forum id database by query. Method return
	 * ArrayList<Integer> of identifiers most used keyWords. Max size of
	 * ArrayList is set to 10.
	 * 
	 * @return ArrayList<Integer> ArrayList of identifiers of ten most used
	 *         keywords.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> topKeyWords() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createNativeQuery(
				"select ID_KEYWORD from (select id_keyword, count(id_keyword) as pocet from topic_keyword group by ID_KEYWORD order by ID_KEYWORD desc)");
		ArrayList<Integer> result = (ArrayList<Integer>) query.setMaxResults(10).getResultList();
		return result;

	}

	/**
	 * Function have to connect to database and try to find all keyWords from
	 * database. Method return ArrayList of all objects of type keyWord.
	 * 
	 * @return ArrayList<KeyWord> ArrayList of objects of type keyWord.
	 * 
	 * @see KeyWord
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<KeyWord> getAllKeyWords() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select k from KeyWord k");
		ArrayList<KeyWord> resultList = (ArrayList<KeyWord>) query.getResultList();
		return resultList;
	}
}