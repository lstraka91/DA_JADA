package sk.tsystems.jada.forum.entity.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.Commentary;
import sk.tsystems.jada.forum.entity.KeyWord;
import sk.tsystems.jada.forum.entity.Person;

import sk.tsystems.jada.forum.entity.Topic;

public class GenerateBasicDbs {
	private CommentaryService commentService = new CommentaryService();
	private TopicService topicService = new TopicService();
	private PersonService personService = new PersonService();
	private Set<KeyWord> keyWords1 = new HashSet<>();
	private Set<KeyWord> keyWords2 = new HashSet<>();
	
	private Admin superAdmin = new Admin("superAdmin", "Qwer123@", "Main Admin", "admin@gmail.com", new Date(System.currentTimeMillis()), true, true, true, true);
	private Admin admin = new Admin("admin", "Asdf123@", "Defaut Admin", "adminko@gmail.com", new Date(System.currentTimeMillis()), false, false, true, true);
	private Person user = new Person("user", "Zxcv123@", "First User", "user@gmail.com", new Date(System.currentTimeMillis()));
	private Topic topic1 = new Topic("Hardware", "topic about hardware", keyWords1, user);
	private Topic topic2 = new Topic("Software", "topic about software", keyWords2, admin);
	private Commentary comment1 = new Commentary("Hardver je súhrnný názov pre technické vybavenie poèítaèa a poèítaèových komponentov.", user, topic1);
	private Commentary comment2 = new Commentary("Medzi hardvér patria všetky poèítaèe a ich súèasti.", user, topic1);
	private Commentary comment3 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin, topic2);
	
	/**
	 * Method for generate basic data in database
	 */
	public void generateDbs(){
		
		keyWords1.add(new KeyWord("mouse"));
		keyWords1.add(new KeyWord("keyboard"));
		keyWords1.add(new KeyWord("monitor"));
		
		keyWords2.add(new KeyWord("notepad"));
		keyWords2.add(new KeyWord("office"));
		keyWords2.add(new KeyWord("games"));
		
		personService.registerPerson(user);
		personService.registerPerson(superAdmin);
		personService.registerPerson(admin);
		
		topicService.addTopic(topic1);
		topicService.addTopic(topic2);
		
		commentService.addComent(comment1);
		commentService.addComent(comment2);
		commentService.addComent(comment3);
		
	}
	
	/**
	 * Method for drop all tables from database
	 */
	public void deleteTables(){
		JpaHelper.beginTransaction();
		EntityManager em = JpaHelper.getEntityManager();
		Query query = em.createNativeQuery("drop table topic_keyword");
		query.executeUpdate();
		query = em.createNativeQuery("drop table keyword");
		query.executeUpdate();
		query = em.createNativeQuery("drop table Ratinggg");
		query.executeUpdate();
		query = em.createNativeQuery("drop table Commentary");
		query.executeUpdate();
		query = em.createNativeQuery("drop table topic_viewerslist");
		query.executeUpdate();
		query = em.createNativeQuery("drop table Topic");
		query.executeUpdate();
		query = em.createNativeQuery("drop table Person");
		query.executeUpdate();
		JpaHelper.commitTransaction();
	}
	
	public static void main(String[] args) {
		GenerateBasicDbs gdbs = new GenerateBasicDbs();
		gdbs.generateDbs();
	}
}
