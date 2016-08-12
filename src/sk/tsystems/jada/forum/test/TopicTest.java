package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.PersonService;
import sk.tsystems.jada.forum.entity.services.TopicService;

public class TopicTest {

	TopicService ts = new TopicService();
	PersonService ps = new PersonService();
	Person person = ps.getPersonByName("Tomas");

	@Test
	public void testAddTopic() {
		ts.addTopic(createTopic());
		assertNotNull(ts.findTopicById(ts.getIdTopicByName("mytesttopic")));
	}

	// @Test
	// public void testRemoveTopicById(){
	// ts.addTopic(createTopic());
	// int id = ts.getIdTopicByName("mytesttopic");
	// ts.removeTopicById(id);
	// assertNull(ts.findTopicById(ts.getIdTopicByName("mytesttopic")));
	// }

	@Test
	public void testUpdateTopicName() {
		ts.addTopic(createTopic());
		int id = ts.getIdTopicByName("mytesttopic");
		ts.updateTopicName(id, "nehehe");
		Topic t = ts.findTopicById(id);
		assertEquals("nehehe", t.getTopicName());

	}

	@Test
	public void testUpdateTopicDescription() {
		ts.addTopic(createTopic());
		int id = ts.getIdTopicByName("mytesttopic");
		ts.updateTopicDescrition(id, "new description");
		Topic tt = ts.findTopicById(id);
		assertEquals("new description", tt.getTopicDescription());
	}

	@Test
	public void testShowTopics() {
		assertNotNull(ts.showTopics());
	}

	@Test
	public void testGetIdTopicByName() {
		ts.addTopic(createTopic());
		int id = ts.getIdTopicByName("mytesttopic");
		Topic tc = ts.findTopicById(id);
		assertEquals(id, tc.getIdTopic());
	}

	@Test
	public void testFindTopicById() {
		ts.addTopic(createTopic());
		int id = ts.getIdTopicByName("mytesttopic");
		Topic tr = ts.findTopicById(id);
		assertEquals("mytesttopic", tr.getTopicName());
	}

	private Topic createTopic() {
		Topic topic = new Topic();
		topic.setTopicName("myTestTopic");
		topic.setPerson(person);
		topic.setTopicDescription("description of this topic");
		return topic;
	}

}
