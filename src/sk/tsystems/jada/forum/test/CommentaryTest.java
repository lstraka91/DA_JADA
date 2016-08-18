package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.CommentaryService;
import sk.tsystems.jada.forum.entity.services.PersonService;
import sk.tsystems.jada.forum.entity.services.TopicService;

public class CommentaryTest {

	TestService ts = new TestService();
	CommentaryService cs = new CommentaryService();
	TopicService tcs = new TopicService();
	PersonService ps = new PersonService();

	@Before
	public void beforeTesting() {
		ts.createPersons();
		ts.createKeyWords();
		ts.createTopics();
		ts.createComments();
	}

	@After
	public void afterTesting() {
		ts.removeComments();
		ts.removeTopics();
		ts.removekeyWords();
		ts.removePersons();
	}

	@Test
	public void testAddComent() {
		Commentary c5 = new Commentary();
		c5.setCommentaryBody("Fifth commentary for testing");
		c5.setCommentaryDate(new Date());
		Person pt = ps.getPersonByName("TestPerson1");
		c5.setPerson(pt);
		Topic tc1 = tcs.findTopicById(tcs.getIdTopicByName("myTestTopic1"));
		c5.setTopic(tc1);
		cs.addComent(c5);
		assertNotNull(cs.getCommentByText("Fifth commentary for testing"));
		cs.removeCommentById(cs.getCommentByText("Fifth commentary for testing").getIdCommentary());
	}

	@Test
	public void testSelectAllComent() {
		assertNotNull(cs.selectAllComent());
	}

	@Test
	public void testSelectAllComentByTopic() {
		Topic topic = tcs.findTopicById(tcs.getIdTopicByName("myTestTopic1"));
		List<Commentary> list = cs.selectAllComentByTopic(topic);
		for (Commentary commentary : list) {
			assertEquals(commentary.getTopic().getIdTopic(), topic.getIdTopic());
		}
	}

	@Test
	public void testSelectAllComentByPerson() {
		Person person = ps.getPersonByName("TestPerson1");
		List<Commentary> list = cs.selectAllComentByPerson(person);
		for (Commentary commentary : list) {
			assertEquals(commentary.getPerson().getIdPerson(), person.getIdPerson());
		}
	}

	@Test
	public void testRemoveCommentById() {
		ts.createComment4();
		Commentary comment = cs.getCommentByText("Fourth commentary for testing");
		int id = comment.getIdCommentary();
		cs.removeCommentById(id);
		List<Commentary> list = cs.selectAllComent();
		for (Commentary commentary : list) {
			assertNotEquals(id, commentary.getIdCommentary());
		}
	}

	@Test
	public void testRemoveCommentByObject() {
		ts.createComment4();
		Commentary comment = cs.getCommentByText("Fourth commentary for testing");
		cs.removeCommentByObject(comment);
		assertNull(cs.getCommentByText("Fourth commentary for testing"));
	}

	@Test
	public void testSelectCommentById() {
		Commentary comment = cs.getCommentByText("First commentary for testing");
		int id = comment.getIdCommentary();
		assertEquals(id, cs.selectCommentById(comment.getIdCommentary()).getIdCommentary());

	}

	@Test
	public void testGetCommentByText() {
		Commentary c = cs.getCommentByText("First commentary for testing");
		assertEquals("First commentary for testing", c.getCommentaryBody());
	}
	
	@Test
	public void testUpdateCommentBody() {
		Commentary c = cs.getCommentByText("First commentary for testing");
		cs.updateCommentBody(c, "new comment body");
		Commentary c1 = cs.getCommentByText("new comment body");
		assertEquals("new comment body", c1.getCommentaryBody());
	}
}
