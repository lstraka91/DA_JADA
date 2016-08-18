/**
 * @author Branislav Popadiè
 */
package sk.tsystems.jada.forum.entity.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Rating;
import sk.tsystems.jada.forum.entity.RatingId;
import sk.tsystems.jada.forum.entity.Topic;

public class PersonService {

	/**
	 * Find object of Class Person in database by persons ID.
	 *
	 * @param idPerson
	 * @return Object Person with parameter idPerson.
	 */
	@SuppressWarnings("unused")
	private Person getPersonByID(int idPerson) {
		Person person = null;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person where p.idPerson =: idPerson");
		query.setParameter("idPerson", idPerson);
		if (!query.getResultList().isEmpty()) {
			person = (Person) query.getResultList().get(0);
		}
		return person;
	}

	/**
	 * Find object of Class Person in database by persons name.
	 * 
	 * @param personName
	 * @return Object Person with requested personName or null when person not
	 *         in database.
	 */
	public Person getPersonByName(String personName) {
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
	 * Find object of Class Person in database by persons name and his password.
	 * 
	 * @param personName
	 * @return Object Person with requested personName or null when person not
	 *         in database.
	 */
	public Person getPersonByNameAndPass(String personName, String password) {
		Person person;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em
				.createQuery("select p from Person p where p.personName = :personName and p.password = :password");

		query.setParameter("personName", personName);
		query.setParameter("password", encryptPassword(password));
		if (!query.getResultList().isEmpty()) {
			person = (Person) query.getResultList().get(0);
			return person;
		} else {
			return null;
		}
	}

	/**
	 * Checks if player is already in database or persists new object of player
	 * in database.
	 * 
	 * @param person
	 * @return returns null if person already is in database otherwise persists
	 *         Player in database and returns Player.
	 */
	public Person registerPerson(Person person) {

		Person foundPerson = getPersonByName(person.getPersonName());
		if (foundPerson != null) {
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
		person.setPassword(encryptPassword(person.getPassword()));
		em.persist(person);
		JpaHelper.commitTransaction();
	}

	/**
	 * Update person data / fullname and email
	 * 
	 * @param person
	 * @param updatePerson
	 */
	public void updatePersonProfile(Person person, Person updatePerson) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Person editPerson = em.find(Person.class, person.getIdPerson());
		if (updatePerson.getEmail() != null) {
			editPerson.setEmail(updatePerson.getEmail());
		}
		if (updatePerson.getFullName() != null) {
			editPerson.setFullName(updatePerson.getFullName());
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Change person password
	 * 
	 * @param person
	 * @param newPassword
	 */
	public void changePersonPassword(Person person, String newPassword) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Person editPerson = em.find(Person.class, person.getIdPerson());
		editPerson.setPassword(encryptPassword(newPassword));
		JpaHelper.commitTransaction();
	}

	/**
	 * Encryption of User password with MD5 algorithm
	 * 
	 * @param password
	 *            password to encrypt
	 * @return String representation of encrypted password
	 */
	public static String encryptPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Person> getPersonsOrderByDtype() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p order by dtype ");
		if (query.getResultList() != null) {
			ArrayList<Person> resultList = (ArrayList<Person>) query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Person> getPersonsOrderByActiv() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p order by active ");
		if (query.getResultList() != null) {
			ArrayList<Person> resultList = (ArrayList<Person>) query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Person> getPersonsOrderByRegistrationDate() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p order by registrationDate desc ");
		if (query.getResultList() != null) {
			ArrayList<Person> resultList = (ArrayList<Person>) query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Person> getPersonsOrderByPersonName() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p order by p.personName  ");
		if (query.getResultList() != null) {
			ArrayList<Person> resultList = (ArrayList<Person>) query.getResultList();
			return resultList;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public int getNumberOfActivationRequests() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p");
		int count = 0;
		ArrayList<Person> resultList = (ArrayList<Person>) query.getResultList();
		for (int i = 0; i < resultList.size(); i++) {

			if (resultList.get(i).isActive() == false) {
				count++;
			}
		}
		return count;
	}

	public void setRemovedPerson(Person person) {
		Person removedPerson = new Person();
		removedPerson = new PersonService().getPersonByName("Removed User");

		List<Commentary> commList = new CommentaryService().selectAllComentByPerson(person);
		if (commList != null) {
			for (Commentary commentary : commList) {
				JpaHelper.beginTransaction();
				EntityManager em = JpaHelper.getEntityManager();
				Commentary comm = em.find(Commentary.class, commentary.getIdCommentary());
				comm.setPerson(removedPerson);
				JpaHelper.commitTransaction();
			}
		}
		List<Rating> ratingList = new RatingService().selectAllRatingsByPerson(person);
		System.out.println(ratingList);
		if (ratingList != null) {
			for (Rating rating : ratingList) {
				JpaHelper.beginTransaction();
				EntityManager em = JpaHelper.getEntityManager();
				RatingId rid = rating.getRatingIdCompositePK();
				rid.setIdPerson(removedPerson.getIdPerson());
				JpaHelper.commitTransaction();
				EntityTransaction updt = em.getTransaction();
				updt.begin();
				em.createQuery(
						"update Rating set ratingIdCompositePK.idPerson=:rating where ratingIdCompositePK.idPerson=:ratingId")
						.setParameter("rating", rid.getIdPerson()).setParameter("ratingId", person.getIdPerson())
						.executeUpdate();
				updt.commit();
			}
		}
		List<Topic> topicList = new TopicService().selectAllTopicsByPerson(person);
		if (topicList != null) {
			for (Topic topic : topicList) {
				JpaHelper.beginTransaction();
				EntityManager em = JpaHelper.getEntityManager();
				Topic top = em.find(Topic.class, topic.getIdTopic());
				top.setPerson(removedPerson);
				JpaHelper.commitTransaction();
			}
		}

	}

}
