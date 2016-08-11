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


//	@Test
//	public void testAddTopic() {
//		ts.addTopic(createTopic());
//		assertNotNull(ts.findTopicById(ts.getIdTopicByName("mytesttopic")));
//	}

	@Test
	public void testRemoveTopicById(){
//		ts.addTopic(createTopic());
		int id = ts.getIdTopicByName("mytesttopic");
		ts.removeTopicById(id);
		assertNull(ts.findTopicById(ts.getIdTopicByName("mytesttopic")));
	}
	
//	@Test
//	public void testUpdateTopicName(){
//		topic.setTopicName(topicName);
//		Person person = ps.getPersonByName("Tomas");
//		topic.setPerson(person);
//		topic.setTopicDescription("description of this topic");
//		ts.addTopic(topic);
//		ts.updateTopicName(idTopic, topicName);
//	}
	
	private Topic createTopic(){
		Topic topic = new Topic();
		topic.setTopicName("myTestTopic");
		topic.setPerson(person);
		topic.setTopicDescription("description of this topic");
		return topic;
	}

}
