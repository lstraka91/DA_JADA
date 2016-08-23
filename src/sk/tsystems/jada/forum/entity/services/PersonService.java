/**
 * @author Branislav Popadiè
 */
package sk.tsystems.jada.forum.entity.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
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
	 * Find object Person in database by persons ID, if nothing was found in
	 * database, method return null otherwise return object of type Person
	 *
	 * @param idPerson
	 *            identification number of person
	 * 
	 * @return Object Person or null if nothing found
	 * 
	 * @see Person
	 */
	public Person getPersonByID(int idPerson) {
		Person person = null;
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p where p.idPerson =:idPerson");
		query.setParameter("idPerson", idPerson);
		if (!query.getResultList().isEmpty()) {
			person = (Person) query.getResultList().get(0);
		}
		return person;
	}

	/**
	 * Find object of Person in database by user userName, if nothing was found
	 * in database, method return null otherwise return object of type Person
	 * 
	 * @param personName
	 *            unique user userName by which is searching in database
	 * 
	 * @return Object Person with requested personName or null when person not
	 *         in database.
	 * 
	 * @see Person
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
	 * Method that is useful to logging to application by userName and password,
	 * on success return object of type Person other wise return null
	 * 
	 * @param personName
	 *            unique user userName by which is searching in database
	 * 
	 * @param password
	 *            users password
	 * 
	 * @return Object Person with requested personName and password or null when
	 *         person not in database or userName and password no matched.
	 * 
	 * @see Person
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
	 * in database. If person already exist the method returns null and nothing
	 * done. If person doesn't exist yet, it create a new one Person and save it
	 * to database
	 * 
	 * Use the {@link PersonService #getPersonByName(String)} method
	 * 
	 * Use the {@link Person #getPersonName()} method
	 * 
	 * Use the {@link PersonService #insertPerson(Person)} method
	 * 
	 * @param person
	 *            Person which trying to save to database and check if already
	 *            not exists
	 * 
	 * @return returns null if person already is in database otherwise persists
	 *         Player in database and returns Player.
	 * 
	 * @see Person
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
	 * Use the {@link Person #setPassword(String)} method
	 * 
	 * Use the {@link PersonService #encryptPassword(String)} method
	 * 
	 * Use the {@link Person #getPassword()} method
	 * 
	 * @param person
	 *            object of type Person
	 * 
	 * @see Person
	 */
	private void insertPerson(Person person) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		person.setPassword(encryptPassword(person.getPassword()));
		em.persist(person);
		JpaHelper.commitTransaction();
	}

	/**
	 * Method that could update some personal information of person. Person is
	 * trying to find existing person and after that update some new information
	 * from new person to old person and save updated information to database
	 * 
	 * Use the {@link Person #getIdPerson()} method
	 * 
	 * Use the {@link Person #getEmail()} method
	 * 
	 * Use the {@link Person #setEmail(String)} method
	 * 
	 * Use the {@link Person #getFullName()} method
	 * 
	 * Use the {@link Person #setFullName(String)} method
	 * 
	 * @param person
	 *            existing object of person in Database that is trying to update
	 * 
	 * @param updatePerson
	 *            new object in which is shared some information about new
	 *            updated personal information
	 * 
	 * @see Person
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
	 * Method that trying to change password for existing Person
	 * 
	 * Use the {@link Person #setPassword(String)} method
	 * 
	 * Use the {@link PersonService #encryptPassword(String)} method
	 * 
	 * @param person
	 *            existing person in database to which is trying to change the
	 *            password
	 * 
	 * @param newPassword
	 *            new String representation of password
	 * 
	 * @see Person
	 */
	public void changePersonPassword(Person person, String newPassword) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Person editPerson = em.find(Person.class, person.getIdPerson());
		editPerson.setPassword(encryptPassword(newPassword));
		JpaHelper.commitTransaction();
	}

	/**
	 * Encryption of User password with MD5 algorithm. Method that encrypt the
	 * password by MessageDigest object with MD5 algorithm. Method return new
	 * encrypted String representation of password or null if something goes
	 * wrong
	 * 
	 * @param password
	 *            String representation of password to encrypt
	 * 
	 * @return String representation of encrypted password or null if encryption
	 *         crashed
	 * 
	 * @see MessageDigest
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

	/**
	 * Returns an arrayList of Persons from database that are ordered by
	 * discriminator type in database
	 * 
	 * @return null if there is nothing in database otherwise return ordered
	 *         arrayList of type Person by type of object
	 * 
	 * @see Person
	 */
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

	/**
	 * Returns an arrayList of Persons from database that are ordered by
	 * activation property so if the person is activated in database
	 * 
	 * @return arrayList of person ordered by activation property or null if
	 *         there is no person in table
	 * 
	 * @see Person
	 */
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

	/**
	 * Returns an arrayList of Persons from database that are ordered by date of
	 * registration in database
	 * 
	 * @return arrayList of Person objects that are ordered by registration date
	 *         or null if there is no Persons in database
	 * 
	 * @see Person
	 */
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

	/**
	 * Returns an arrayList of Persons from database that are ordered by
	 * userName in database
	 * 
	 * @return arrayList of Persons object ordered by userName or null if
	 *         nothing found in database
	 * 
	 * @see Person
	 */
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

	/**
	 * Return count of persons that are not activated
	 * 
	 * @return value of count not activated person in database
	 * 
	 * @see Person
	 */
	@SuppressWarnings("unchecked")
	public int getNumberOfActivationRequests() {
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createQuery("select p from Person p");
		int count = 0;
		ArrayList<Person> resultList = (ArrayList<Person>) query.getResultList();
		for (int i = 0; i < resultList.size(); i++) {
			Person removedPerson = new PersonService().getPersonByName("Removed User");
			if (!removedPerson.getPersonName().equals(resultList.get(i).getPersonName())) {
				if (resultList.get(i).isActive() == false) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Method that change all persons data to default removed user type. It
	 * provide that all data in database are not deleted from database but only
	 * change to new type of Person but person are currently removed from
	 * database at the end of all changing person data changing
	 * 
	 * Use the {@link PersonService #getPersonByName(String)} method
	 * 
	 * Use the {@link CommentaryService #selectAllComentByPerson(Person)} method
	 * 
	 * Use the {@link Commentary #getIdCommentary()} method
	 * 
	 * Use the {@link Commentary #setPerson(Person)} method
	 * 
	 * Use the {@link RatingService #selectAllRatingsByPerson(Person)} method
	 * 
	 * Use the {@link Rating #getRatingIdCompositePK()} method
	 * 
	 * Use the {@link RatingId #setIdPerson(Integer)} method
	 * 
	 * Use the {@link Person #getIdPerson()} method
	 * 
	 * Use the {@link TopicService #selectAllTopicsByPerson(Person)} method
	 * 
	 * Use the {@link Topic #getIdTopic()} method
	 * 
	 * Use the {@link Topic #setPerson(Person)} method
	 * 
	 * @param person
	 *            person by which is all updated in database
	 * 
	 * @see Person
	 * @see Rating
	 * @see RatingId
	 * @see Commentary
	 * @see Topic
	 */
	public void setRemovedPerson(Person person) {
		Person removedPerson = new Person();
		removedPerson = new PersonService().getPersonByName("Removed User");
		if (removedPerson == null) {
			removedPerson = new Person("Removed User", "ahahsju@1235", "Removed", "removed@user.sk",
					new Date(System.currentTimeMillis()));
			registerPerson(removedPerson);
		}
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
		removeUser(person);
	}

	/**
	 * Method that disable person by name
	 * 
	 * Use the {@link PersonService #getPersonByName(String)} method
	 * 
	 * Use the {@link Person #setActive(boolean)} method
	 * 
	 * @param name
	 * 
	 * @see Person
	 */
	public void dissablePerson(String name) {
		JpaHelper.beginTransaction();
		Person person = new PersonService().getPersonByName(name);
		if (person != null) {
			person.setActive(false);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method that active person by name
	 * 
	 * Use the {@link PersonService #getPersonByName(String)} method
	 * 
	 * Use the {@link Person #setActive(boolean)} method
	 * 
	 * @param name
	 * 
	 * @see Person
	 */
	public void activatePerson(String name) {
		JpaHelper.beginTransaction();
		Person person = new PersonService().getPersonByName(name);
		if (person != null) {
			person.setActive(true);
		}
		JpaHelper.commitTransaction();
	}

	/**
	 * Method that remove user from database by object Person
	 * 
	 * @param person
	 *            object of type Person
	 * 
	 * @see Person
	 */
	private void removeUser(Person person) {
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.beginTransaction();
		em.remove(person);
		JpaHelper.commitTransaction();
	}
}
