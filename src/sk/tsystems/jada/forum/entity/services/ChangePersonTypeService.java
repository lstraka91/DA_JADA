package sk.tsystems.jada.forum.entity.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Rating;
import sk.tsystems.jada.forum.entity.RatingId;
import sk.tsystems.jada.forum.entity.SuperAdmin;
import sk.tsystems.jada.forum.entity.Topic;

public class ChangePersonTypeService {

	/**
	 * Method that try to make an new type of Person from Person to
	 * Administrator object, method try to make new Object type of Admin and
	 * share to that object all existing data from parameter and change all
	 * references in database from old one Person to new one. New type of object
	 * Admin have to default set the permissions to false
	 * 
	 * Use the {@link Person #getPersonName()} method
	 * 
	 * Use the {@link Person #getPassword()} method
	 * 
	 * Use the {@link Person #getFullName()} method
	 * 
	 * Use the {@link Person #getEmail()} method
	 * 
	 * Use the {@link Person #getBirthday()} method
	 * 
	 * Use the
	 * {@link ChangePersonTypeService #changeAllPersonIds(Person, Person)}
	 * method
	 * 
	 * @param person
	 *            Object that try to change to other type
	 * 
	 * @see Admin
	 * @see Person
	 */
	public void changePersonToAdmin(Person person) {
		Admin admin = new Admin(person.getPersonName(), person.getPassword(), person.getFullName(), person.getEmail(),
				person.getBirthday(), false, false, false, false);
		changeAllPersonIds(person, admin);
	}

	/**
	 * Method that try to make an new type of Person from Person to SuperAdmin
	 * object, method try to make new Object type of SuperAdmin and share to
	 * that object all existing data from parameter and change all references in
	 * database from old one Person to new one. New type of object SuperAdmin
	 * have default set the permissions to true because Super administrator is
	 * the strongest role in the application so default have all permission sets
	 * to true
	 * 
	 * Use the {@link Person #getPersonName()} method
	 * 
	 * Use the {@link Person #getPassword()} method
	 * 
	 * Use the {@link Person #getFullName()} method
	 * 
	 * Use the {@link Person #getEmail()} method
	 * 
	 * Use the {@link Person #getBirthday()} method
	 * 
	 * Use the
	 * {@link ChangePersonTypeService #changeAllPersonIds(Person, Person)}
	 * method
	 * 
	 * @param person
	 *            Object that try to change to other type
	 * 
	 * @see SuperAdmin
	 * @see Person
	 */
	public void changePersonToSuperAdmin(Person person) {
		SuperAdmin superAdmin = new SuperAdmin(person.getPersonName(), person.getPassword(), person.getFullName(),
				person.getEmail(), person.getBirthday());
		changeAllPersonIds(person, superAdmin);
	}

	/**
	 * Method that try to make an new type of Person from Admin or SuperAdmin to
	 * default user Person object, method try to make new Object type of Person
	 * and share to that object all existing data from parameter and change all
	 * references in database from old one Person to new one. Object type of
	 * Person have no administration permission data so if old Object have some
	 * administrator permission they are set to new object by default to null
	 * because Person object have no permission
	 * 
	 * Use the {@link Person #getPersonName()} method
	 * 
	 * Use the {@link Person #getPassword()} method
	 * 
	 * Use the {@link Person #getFullName()} method
	 * 
	 * Use the {@link Person #getEmail()} method
	 * 
	 * Use the {@link Person #getBirthday()} method
	 * 
	 * Use the
	 * {@link ChangePersonTypeService #changeAllPersonIds(Person, Person)}
	 * method
	 * 
	 * @param person
	 *            Object that try to change to other type
	 * 
	 * @see Person
	 */
	public void changeAdminToPerson(Person person) {
		Person newPerson = new Person(person.getPersonName(), person.getPassword(), person.getFullName(),
				person.getEmail(), person.getBirthday());
		changeAllPersonIds(person, newPerson);
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

	/**
	 * Method that select all topics by person and if result is not null then
	 * all topics add new person
	 * 
	 * Use the {@link TopicService #selectAllTopicsByPerson(Person)} method
	 * 
	 * Use the {@link Topic #getIdTopic()} method
	 * 
	 * Use the {@link Topic #setPerson(Person)} method
	 * 
	 * @param person
	 * @param newPerson
	 * 
	 * @see Person
	 * @see Topic
	 */
	private void changeTopicPerson(Person person, Person newPerson) {
		List<Topic> topics = new TopicService().selectAllTopicsByPerson(person);
		if (topics != null) {
			for (Topic topic : topics) {
				JpaHelper.beginTransaction();
				EntityManager em = JpaHelper.getEntityManager();
				Topic t = em.find(Topic.class, topic.getIdTopic());
				t.setPerson(newPerson);
				JpaHelper.commitTransaction();
			}
		}
	}

	/**
	 * Method that select all comments by person and if result is not null then
	 * all comments add new person
	 * 
	 * Use the {@link CommentaryService #selectAllComentByPerson(Person)} method
	 * 
	 * Use the {@link Commentary #getIdCommentary()} method
	 * 
	 * Use the {@link Commentary #setPerson(Person)} method
	 * 
	 * @param person
	 * @param newPerson
	 * 
	 * @see Person
	 * @see Commentary
	 */
	private void changeCommentPerson(Person person, Person newPerson) {
		List<Commentary> comments = new CommentaryService().selectAllComentByPerson(person);
		if (comments != null) {
			for (Commentary commentary : comments) {
				JpaHelper.beginTransaction();
				EntityManager em = JpaHelper.getEntityManager();
				Commentary c = em.find(Commentary.class, commentary.getIdCommentary());
				c.setPerson(newPerson);
				JpaHelper.commitTransaction();
			}
		}
	}

	/**
	 * Method that select all ratings by person and if result is not null then
	 * all ratings add new person
	 * 
	 * Use the {@link RatingService #selectAllRatingsByPerson(Person)} method
	 * 
	 * Use the {@link Rating #getRatingIdCompositePK()} method
	 * 
	 * Use the {@link RatingId #setIdPerson(Integer)} method
	 * 
	 * Use the {@link Person #getIdPerson()} method
	 * 
	 * Use the {@link RatingId #getIdPerson(Integer)} method
	 * 
	 * @param person
	 * @param newPerson
	 * 
	 * @see Person
	 * @see Rating
	 */
	private void changeRatingPerson(Person person, Person newPerson) {
		List<Rating> ratings = new RatingService().selectAllRatingsByPerson(person);
		if (ratings != null) {
			for (Rating rating : ratings) {
				JpaHelper.beginTransaction();
				EntityManager em = JpaHelper.getEntityManager();
				RatingId rid = rating.getRatingIdCompositePK();
				rid.setIdPerson(newPerson.getIdPerson());
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
	}

	/**
	 * Method that create copy of object Person and save to database
	 * 
	 * @param person
	 *            object of type Person
	 */
	private void createCopiedPerson(Person person) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(person);
		JpaHelper.commitTransaction();
	}

	/**
	 * Method that change completely two users with their comments, topics,
	 * ratings
	 * 
	 * Use the {@link ChangePersonTypeService #createCopiedPerson(Person)}
	 * method
	 * 
	 * Use the
	 * {@link ChangePersonTypeService #changeCommentPerson(Person, Person)}
	 * method
	 * 
	 * Use the
	 * {@link ChangePersonTypeService #changeRatingPerson(Person, Person)}
	 * method
	 * 
	 * Use the {@link ChangePersonTypeService #changeTopicPerson(Person,
	 * Person))} method
	 * 
	 * Use the {@link ChangePersonTypeService #removeUser(Person)} method
	 * 
	 * @param person
	 *            object of type Person
	 * 
	 * @param changedPerson
	 *            object of type Person
	 * 
	 * @see Person
	 */
	private void changeAllPersonIds(Person person, Person changedPerson) {
		createCopiedPerson(changedPerson);
		changeCommentPerson(person, changedPerson);
		changeRatingPerson(person, changedPerson);
		changeTopicPerson(person, changedPerson);
		removeUser(person);
	}
}
