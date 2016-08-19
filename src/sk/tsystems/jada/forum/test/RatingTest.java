package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Rating;
import sk.tsystems.jada.forum.entity.services.CommentaryService;
import sk.tsystems.jada.forum.entity.services.PersonService;
import sk.tsystems.jada.forum.entity.services.RatingService;
import sk.tsystems.jada.forum.entity.services.TopicService;

public class RatingTest {

	TestService ts = new TestService();
	CommentaryService cs = new CommentaryService();
	TopicService tcs = new TopicService();
	PersonService ps = new PersonService();
	RatingService rs = new RatingService();

	@Before
	public void beforeTesting() {
		ts.createPersons();
		ts.createKeyWords();
		ts.createTopics();
		ts.createComments();
		ts.createRatings();
	}

	@After
	public void afterTesting() {
		ts.removeRatings();
		ts.removeComments();
		ts.removeTopics();
		ts.removekeyWords();
		ts.removePersons();
	}

	@Test
	public void testAddRating() {
		Person person = ps.getPersonByName("TestPerson2");
		Commentary commentary = cs.getCommentByText("Second commentary for testing");
		Rating rate = new Rating(15, person, commentary);
		rs.addRating(rate);
		assertNotNull(rs.getRatingByRating(rate));
	}

	@Test
	public void testGetRatingOfComment() {
		Commentary commentary = cs.getCommentByText("Second commentary for testing");
		int rating = rs.getRatingOfComment(commentary);
		assertEquals(24, rating);
	}

	@Test
	public void testGetRatingByRating() {
		Person person = ps.getPersonByName("TestPerson2");
		Commentary commentary = cs.getCommentByText("Second commentary for testing");
		Rating rate = new Rating(15, person, commentary);
		rs.addRating(rate);
		assertEquals(rate.getRate(), rs.getRatingByRating(rate).getRate());
		assertEquals(rate.getRatingIdCompositePK().getIdPerson(),
				rs.getRatingByRating(rate).getRatingIdCompositePK().getIdPerson());
		assertEquals(rate.getRatingIdCompositePK().getIdCommentary(),
				rs.getRatingByRating(rate).getRatingIdCompositePK().getIdCommentary());
	}

	@Test
	public void testGetCountOfCommentRating() {
		Commentary commentary = cs.getCommentByText("Second commentary for testing");
		int count = rs.getCountOfCommentRating(commentary);
		assertEquals(2, count);
	}

	@Test
	public void testSelectAllRatingsByPerson() {
		Person person = ps.getPersonByName("TestPerson2");
		List<Rating> list = rs.selectAllRatingsByPerson(person);
		for (Rating rating : list) {
			assertEquals(person.getIdPerson(), rating.getRatingIdCompositePK().getIdPerson());
		}
	}

}
