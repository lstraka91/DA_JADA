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

	public void changePersonToAdmin(Person person) {
		Admin admin = new Admin(person.getPersonName(), person.getPassword(), person.getFullName(), person.getEmail(),
				person.getBirthday(), false, false, false, false);
		changeAllPersonIds(person, admin);
	}

	public void changePersonToSuperAdmin(Person person) {
		SuperAdmin superAdmin = new SuperAdmin(person.getPersonName(), person.getPassword(), person.getFullName(),
				person.getEmail(), person.getBirthday());
		changeAllPersonIds(person, superAdmin);
	}

	public void changeAdminToPerson(Person person) {
		Person newPerson = new Person(person.getPersonName(), person.getPassword(), person.getFullName(),
				person.getEmail(), person.getBirthday());
		changeAllPersonIds(person, newPerson);
	}

	private void removeUser(Person person) {
		EntityManager em = JpaHelper.getEntityManager();
		JpaHelper.beginTransaction();
		em.remove(person);
		JpaHelper.commitTransaction();
	}

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

	private void createCopiedPerson(Person person) {
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		em.persist(person);
		JpaHelper.commitTransaction();
	}

	private void changeAllPersonIds(Person person, Person changedPerson) {
		createCopiedPerson(changedPerson);
		changeCommentPerson(person, changedPerson);
		changeRatingPerson(person, changedPerson);
		changeTopicPerson(person, changedPerson);
		removeUser(person);
	}
}
