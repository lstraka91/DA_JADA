package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.CommentWithRatingService;
import sk.tsystems.jada.forum.entity.services.TopicService;

public class CommentWithRatingTest {

	TestService ts = new TestService();

	@Before
	public void beforeTesting() {
		ts.createPersons();
		ts.createKeyWords();
		ts.createTopics();
		ts.createComments();
		ts.createRatings();
		ts.createAdmin();
	}

	@After
	public void afterTesting() {
		ts.removeAdmin();
		ts.removeRatings();
		ts.removeComments();
		ts.removeTopics();
		ts.removekeyWords();
		ts.removePersons();
	}

	@Test
	public void test() {
		TopicService tcs = new TopicService();
		Topic topic = tcs.findTopicById(tcs.getIdTopicByName("myTestTopic1"));
		CommentWithRatingService cwrs = new CommentWithRatingService();
		assertNotNull(cwrs.getCommentsAndRatings(topic));
	}

}
