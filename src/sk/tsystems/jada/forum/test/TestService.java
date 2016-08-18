package sk.tsystems.jada.forum.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.KeyWord;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Rating;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.CommentaryService;
import sk.tsystems.jada.forum.entity.services.JpaHelper;
import sk.tsystems.jada.forum.entity.services.KeyWordService;
import sk.tsystems.jada.forum.entity.services.PersonService;
import sk.tsystems.jada.forum.entity.services.RatingService;
import sk.tsystems.jada.forum.entity.services.TopicService;

public class TestService {

	PersonService ps = new PersonService();
	RatingService rs = new RatingService();

	public void createPerson1() {
		Person p1 = new Person();
		p1.setActive(true);
		p1.setPersonName("TestPerson1");
		p1.setFullName("TestPerson1 Fullname");
		p1.setBirthday(new Date());
		p1.setEmail("TestPerson1@mail.com");
		p1.setRegistrationDate(new Date());
		p1.setPassword("Password@123");
		ps.registerPerson(p1);
	}

	public void createPerson2() {
		Person p2 = new Person();
		p2.setActive(true);
		p2.setPersonName("TestPerson2");
		p2.setFullName("TestPerson2 Fullname");
		p2.setBirthday(new Date());
		p2.setEmail("TestPerson2@mail.com");
		p2.setRegistrationDate(new Date());
		p2.setPassword("passworD@321");
		ps.registerPerson(p2);
	}

	public void removePersonByName(String name) {
		PersonService ps = new PersonService();
		Person p = new Person();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		p = ps.getPersonByName(name);
		if (p != null) {
			em.remove(p);
			JpaHelper.commitTransaction();
		} else {
			JpaHelper.commitTransaction();
		}
	}

	public void createPersons() {
		createPerson1();
		createPerson2();
	}

	public void removePersons() {
		removePersonByName("TestPerson1");
		removePersonByName("TestPerson2");
		removePersonByName("TestPerson3");
	}

	public void createKeyWords() {
		KeyWordService ks = new KeyWordService();
		ks.findKeyWord("testKeyWord1");
		ks.findKeyWord("testKeyWord2");
		ks.findKeyWord("testKeyWord3");
		ks.findKeyWord("testKeyWord4");
		ks.findKeyWord("testKeyWord5");
		ks.findKeyWord("testKeyWord6");
	}

	public void removekeyWord(String keyWord) {
		KeyWordService ks = new KeyWordService();
		KeyWord k = new KeyWord();
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		k = ks.findKeyWord(keyWord.toLowerCase());
		if (k != null) {
			em.remove(k);
			JpaHelper.commitTransaction();
		} else {
			JpaHelper.commitTransaction();
		}
	}

	public void removekeyWords() {
		removekeyWord("testKeyWord1");
		removekeyWord("testKeyWord2");
		removekeyWord("testKeyWord3");
		removekeyWord("testKeyWord4");
		removekeyWord("testKeyWord5");
		removekeyWord("testKeyWord6");
	}

	public void createTopics() {
		Topic t1 = new Topic();
		t1.setTopicName("myTestTopic1");
		t1.setTopicDescription("description of first test topic");
		Person pt = ps.getPersonByName("TestPerson1");
		t1.setPerson(pt);
		t1.setTopicDate(new Date());
		TopicService ts = new TopicService();
		ts.addTopic(t1);

		Topic t2 = new Topic();
		t2.setTopicName("myTestTopic2");
		t2.setTopicDescription("description of second test topic");
		t2.setPerson(pt);
		t2.setTopicDate(new Date());
		ts.addTopic(t2);

		Topic t3 = new Topic();
		t3.setTopicName("myTestTopic3");
		t3.setTopicDescription("description of first test topic");
		Person pt2 = ps.getPersonByName("TestPerson2");
		t3.setPerson(pt2);
		t3.setTopicDate(new Date());
		ts.addTopic(t3);
	}

	public void removeTopics() {
		TopicService tcs = new TopicService();
		tcs.removeTopicById(tcs.getIdTopicByName("myTestTopic1"));
		tcs.removeTopicById(tcs.getIdTopicByName("changed name"));
		tcs.removeTopicById(tcs.getIdTopicByName("myTestTopic2"));
		tcs.removeTopicById(tcs.getIdTopicByName("myTestTopic3"));
		tcs.removeTopicById(tcs.getIdTopicByName("myTestTopic4"));
	}

	CommentaryService cs = new CommentaryService();
	TopicService tcs = new TopicService();

	public void createComment1() {
		Commentary c1 = new Commentary();
		c1.setCommentaryBody("First commentary for testing");
		c1.setCommentaryDate(new Date());
		Person pt = ps.getPersonByName("TestPerson1");
		c1.setPerson(pt);
		Topic tc1 = tcs.findTopicById(tcs.getIdTopicByName("myTestTopic1"));
		c1.setTopic(tc1);
		cs.addComent(c1);
	}

	public void createComment2() {
		Commentary c2 = new Commentary();
		c2.setCommentaryBody("Second commentary for testing");
		c2.setCommentaryDate(new Date());
		Person pc = ps.getPersonByName("TestPerson2");
		c2.setPerson(pc);
		Topic tc1 = tcs.findTopicById(tcs.getIdTopicByName("myTestTopic1"));
		c2.setTopic(tc1);
		cs.addComent(c2);
	}

	public void createComment3() {
		Commentary c3 = new Commentary();
		c3.setCommentaryBody("Third commentary for testing");
		c3.setCommentaryDate(new Date());
		c3.setPerson(ps.getPersonByName("TestPerson2"));
		Topic tc2 = tcs.findTopicById(tcs.getIdTopicByName("myTestTopic2"));
		c3.setTopic(tc2);
		cs.addComent(c3);
	}

	public void createComment4() {
		Commentary c4 = new Commentary();
		c4.setCommentaryBody("Fourth commentary for testing");
		c4.setCommentaryDate(new Date());
		c4.setPerson(ps.getPersonByName("TestPerson2"));
		Topic tc2 = tcs.findTopicById(tcs.getIdTopicByName("myTestTopic2"));
		c4.setTopic(tc2);
		cs.addComent(c4);
	}

	public void createComments() {
		createComment1();
		createComment2();
		createComment3();
	}

	public void removeCommentsOfFirstPerson() {
		Person p = ps.getPersonByName("TestPerson1");
		List<Commentary> list = cs.selectAllComentByPerson(p);
		for (Commentary commentary : list) {
			cs.removeCommentByObject(commentary);
		}
	}

	public void removeCommentsOfSecondPerson() {
		Person p = ps.getPersonByName("TestPerson2");
		List<Commentary> list = cs.selectAllComentByPerson(p);
		for (Commentary commentary : list) {
			cs.removeCommentByObject(commentary);
		}
	}

	public void removeComments() {
		removeCommentsOfFirstPerson();
		removeCommentsOfSecondPerson();
	}

	public void createRating1() {
		Person person = ps.getPersonByName("TestPerson1");
		Commentary commentary = cs.getCommentByText("First commentary for testing");

		Rating rating = new Rating(10, person, commentary);
		RatingService rs = new RatingService();
		rs.addRating(rating);
	}

	public void createRating2() {
		Person person = ps.getPersonByName("TestPerson2");
		Commentary commentary = cs.getCommentByText("First commentary for testing");

		Rating rating = new Rating(20, person, commentary);
		RatingService rs = new RatingService();
		rs.addRating(rating);
	}

	public void createRating3() {
		Person person = ps.getPersonByName("TestPerson1");
		Commentary commentary = cs.getCommentByText("Second commentary for testing");

		Rating rating = new Rating(10, person, commentary);
		RatingService rs = new RatingService();
		rs.addRating(rating);
	}

	public void createRating4() {
		Person person = ps.getPersonByName("TestPerson2");
		Commentary commentary = cs.getCommentByText("Second commentary for testing");

		Rating rating = new Rating(14, person, commentary);
		RatingService rs = new RatingService();
		rs.addRating(rating);
	}

	public void createRatings() {
		createRating1();
		createRating2();
		createRating3();
		createRating4();
	}

	public void removeRatingByPerson(String personName) {
		Person person = ps.getPersonByName(personName);

		EntityManager em = JpaHelper.getEntityManager();
		List<Rating> list = rs.selectAllRatingsByPerson(person);
		if (list != null) {
			for (Rating rating : list) {
				JpaHelper.beginTransaction();
				em.remove(rating);
				JpaHelper.commitTransaction();
			}
		}
	}

	public void removeRatings() {
		removeRatingByPerson("TestPerson1");
		removeRatingByPerson("TestPerson2");
	}

}
