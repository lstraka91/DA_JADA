/**
 * @author Branislav Popadiè
 */
package sk.tsystems.jada.forum.entity.services;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Person;

public class PersonService {

	/**
	 * Find object of Class Person in database by persons ID.
	 *
	 * @param idPerson
	 * @return Object Person with parameter idPerson.
	 */
	private Person getPerson(int idPerson) {
		EntityManager em = JpaHelper.getEntityManager();
		return em.find(Person.class, idPerson);
	}

	/**
	 * Find object of Class Person in database by persons name.
	 * 
	 * @param personName
	 * @return Object Person with requested personName or null when person not
	 *         in database.
	 */
	private Person getPersonByName(String personName) {
		Person person;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p where p.personName = :personName");

		query.setParameter("personName", personName);
		if (!query.getResultList().isEmpty()) {
			person = (Person) query.getResultList().get(0);
			return person;
		} else {
			return null;
		}
	}

	/**
	 * Checks if player is already in database or register new player in
	 * database.
	 * 
	 * @param person
	 * @return returns null if person already is in database otherwise persists
	 *         Player in database and returns Player.
	 */
	public Person registerPerson(Person person) {

		int idPerson = getPersonByName(person.getPersonName()).getIdPerson();
		System.out.println(idPerson);
		if (idPerson != 0) {
			return null;
		} else {
			insertPerson(person);
			return person;
		}
	}

	/**
	 * Persists new object of Person into the database.
	 * 
	 * @param person
	 */
	private void insertPerson(Person person) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(person);
		JpaHelper.commitTransaction();
	}

}
