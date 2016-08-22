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
	 * method that try to make an new type of Person from Person to Admin
	 * object, method try to make new Object type of Admin and share to that
	 * object all existing data from parameter and change all references in
	 * database from old one Person to new one. New type of object Admin have to
	 * default set the permisions to false
	 * 
	 * @param person
	 *            Object that try to change to other type
	 * @see Admin
	 * @see Person
	 */
	public void changePersonToAdmin(Person person) {
		Admin admin = new Admin(person.getPersonName(), person.getPassword(), person.getFullName(), person.getEmail(),
				person.getBirthday(), false, false, false, false);
		changeAllPersonIds(person, admin);
	}

	/**
	 * method that try to make an new type of Person from Person to SuperAdmin
	 * object, method try to make new Object type of SuperAdmin and share to
	 * that object all existing data from parameter and change all references in
	 * database from old one Person to new one. New type of object SuperAdmin
	 * have default set the permisions to true because Super admin is the
	 * strongest role in the application so default have all permission sets to
	 * true
	 * 
	 * @param person
	 *            Object that try to change to other type
	 * @see SuperAdmin @ see Person
	 */
	public void changePersonToSuperAdmin(Person person) {
		SuperAdmin superAdmin = new SuperAdmin(person.getPersonName(), person.getPassword(), person.getFullName(),
				person.getEmail(), person.getBirthday());
		changeAllPersonIds(person, superAdmin);
	}

	/**
	 * method that try to make an new type of Person from Admin or SuperAdmin to
	 * default user Person object, method try to make new Object type of Person
	 * and share to that object all existing data from parameter and change all
	 * references in database from old one Person to new one. Object type of
	 * Person have no administration permission data so if old Object have some
	 * admin permission they are set to new object by default to null because
	 * Person object have no permission
	 * 
	 * @param person
	 *            Object that try to change to other type
	 *            @see Person
	 */
	public void changeAdminToPerson(Person person) {
		Person newPerson = new Person(person.getPersonName(), person.getPassword(), person.getFullName(),
				person.getEmail(), person.getBirthday());
		changeAllPersonIds(person, newPerson);
	}

	/**
	 * @param person
	 */
	private void removeUser(Person person) {
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.beginTransaction();
		em.remove(person);
		JpaHelper.commitTransaction();
	}

	/**
	 * @param person
	 * @param newPerson
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
	 * @param person
	 * @param newPerson
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
	 * @param person
	 * @param newPerson
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
	 * @param person
	 */
	private void createCopiedPerson(Person person) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(person);
		JpaHelper.commitTransaction();
	}

	/**
	 * @param person
	 * @param changedPerson
	 */
	private void changeAllPersonIds(Person person, Person changedPerson) {
		createCopiedPerson(changedPerson);
		changeCommentPerson(person, changedPerson);
		changeRatingPerson(person, changedPerson);
		changeTopicPerson(person, changedPerson);
		removeUser(person);
	}
}
