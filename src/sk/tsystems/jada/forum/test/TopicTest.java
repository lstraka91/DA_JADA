package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.Topic;
import sk.tsystems.jada.forum.entity.services.PersonService;
import sk.tsystems.jada.forum.entity.services.TopicService;

public class TopicTest {

	TopicService tcs = new TopicService();
	PersonService ps = new PersonService();
	TestService ts = new TestService();
	
	@Before
	public void beforeTesting(){
		ts.createPersons();
		ts.createKeyWords();
		ts.createTopics();
	}
	
	@After
	public void afterTesting(){
		ts.removePersons();
		ts.removekeyWords();
		ts.removeTopics();
	}

	

	@Test
	public void testAddTopic() {
		Topic t = new Topic();
		t.setTopicName("myTestTopic4");
		t.setTopicDescription("description of fourth test topic");
		Person pt2 = ps.getPersonByName("TestPerson3");
		t.setPerson(pt2);
		t.setTopicDate(new Date());
		tcs.addTopic(t);
		assertNotNull(tcs.findTopicById(tcs.getIdTopicByName("myTestTopic4")));
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
		int id = tcs.getIdTopicByName("myTestTopic2");
		tcs.updateTopicName(id, "changed name");
		Topic t = tcs.findTopicById(id);
		assertEquals("changed name", t.getTopicName());

	}

	@Test
	public void testUpdateTopicDescription() {
		int id = tcs.getIdTopicByName("myTestTopic3");
		tcs.updateTopicDescrition(id, "updated description of third topic");
		Topic tt = tcs.findTopicById(id);
		assertEquals("updated description of third topic", tt.getTopicDescription());
	}

//	@Test
//	public void testShowTopics() {
//		assertNotNull(tcs.showTopics());
//	}

	@Test
	public void testGetIdTopicByName() {
		int id = tcs.getIdTopicByName("myTestTopic1");
		Topic tc = tcs.findTopicById(id);
		assertEquals(id, tc.getIdTopic());
	}

	@Test
	public void testFindTopicById() {
		int id = tcs.getIdTopicByName("myTestTopic3");
		Topic tr = tcs.findTopicById(id);
		assertEquals("myTestTopic3", tr.getTopicName());
	}



}
