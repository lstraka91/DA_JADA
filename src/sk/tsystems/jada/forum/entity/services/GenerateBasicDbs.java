package sk.tsystems.jada.forum.entity.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
	private Set<KeyWord> keyWords3 = new HashSet<>();
	private Set<KeyWord> keyWords4 = new HashSet<>();
	private Set<KeyWord> keyWords5 = new HashSet<>();
	private Set<KeyWord> keyWords6 = new HashSet<>();
	private Set<KeyWord> keyWords7 = new HashSet<>();
	private Set<KeyWord> keyWords8 = new HashSet<>();
	private Set<KeyWord> keyWords9 = new HashSet<>();
	private Set<KeyWord> keyWords10 = new HashSet<>();
	private Set<KeyWord> keyWords11 = new HashSet<>();
	private Set<KeyWord> keyWords12 = new HashSet<>();
	private Set<KeyWord> keyWords13 = new HashSet<>();
	private Set<KeyWord> keyWords14 = new HashSet<>();
	private Set<KeyWord> keyWords15 = new HashSet<>();

	private Person removedPerson = new Person("Removed User", "ahahsju@1235", "Removed", "removed@user.sk",
			new Date(System.currentTimeMillis()));

	private Admin superAdmin = new Admin("superAdmin", "Qwer123@", "Main Admin", "admin@gmail.com",
			new Date(System.currentTimeMillis()), true, true, true, true);
	private Admin admin1 = new Admin("admin1", "Asdf123@", "First Admin", "adminko@gmail.com",
			new Date(System.currentTimeMillis()), false, false, false, true);
	private Admin admin2 = new Admin("admin2", "Asdf123@", "Second Admin", "adminko@gmail.com",
			new Date(System.currentTimeMillis()), false, false, true, false);
	private Admin admin3 = new Admin("admin3", "Asdf123@", "Third Admin", "adminko@gmail.com",
			new Date(System.currentTimeMillis()), false, true, false, false);
	private Admin admin4 = new Admin("admin4", "Asdf123@", "Fourth Admin", "adminko@gmail.com",
			new Date(System.currentTimeMillis()), true, false, false, false);

	private Person user1 = new Person("user1", "Zxcv123@", "First User", "user@gmail.com",
			new Date(System.currentTimeMillis()));
	private Person user2 = new Person("user2", "Zxcv123@", "Second User", "user@gmail.com",
			new Date(System.currentTimeMillis()));
	private Person user3 = new Person("user3", "Zxcv123@", "Third User", "user@gmail.com",
			new Date(System.currentTimeMillis()));
	private Person user4 = new Person("user4", "Zxcv123@", "Fourth User", "user@gmail.com",
			new Date(System.currentTimeMillis()));
	private Person user5 = new Person("user5", "Zxcv123@", "Fifth User", "user@gmail.com",
			new Date(System.currentTimeMillis()));
	private Person user6 = new Person("user6", "Zxcv123@", "Sixth User", "user@gmail.com",
			new Date(System.currentTimeMillis()));

	private Topic topic1 = new Topic("Recyclerview with two datasource from different api calls",
			"I have a recyclerview to display a list of items and a header.", keyWords1, admin1);
	private Topic topic2 = new Topic("How to call different implementations of IWindowCloseHandler in Eclipse E4?",
			"This implementation should be called when the application is running.", keyWords2, user1);
	private Topic topic3 = new Topic("How i can change Language in wordpress",
			"I am making a website using word press , in which I need the back end in English as it is now.", keyWords3,
			admin2);
	private Topic topic4 = new Topic("Ruby: wrong number of arguments in Initialize",
			"This question was voluntarily removed by its author.", keyWords4, user2);
	private Topic topic5 = new Topic(
			"pd.to_datetime or parse datetimes won't work with my cvs file (format: dd/mm/yyyy, hh:mm:ss)",
			"I extracted the following table from my cvs file ", keyWords5, user1);
	private Topic topic6 = new Topic("Swipe to delete on CollectionView",
			"I'm trying to replicate the swipe to delete function like in the mail tableview.", keyWords6, admin2);
	private Topic topic7 = new Topic("Preserve serialization-order of members in CodeDOM",
			"I know we can enforce generating the members within the classes in the same order.", keyWords7, admin1);
	private Topic topic8 = new Topic("Missing data on Android enhanced e-commerce analytics page",
			"I'm measuring my Android app checkout performance by using the google-analytics SDK.", keyWords8, admin1);
	private Topic topic9 = new Topic("Docker Trusted Registry - Unable to satisfy available container slot",
			"I am trying to install the Docker Truster Registry (DTR).", keyWords9, admin1);
	private Topic topic10 = new Topic("java.lang.IllegalArgumentException: expecting IdClass mapping",
			"I have configured composite primary key for my entity Employee as follows", keyWords10, admin1);
	private Topic topic11 = new Topic("List grants and privileges for a materialized view in PostgreSQL",
			"I need to determine what privileges are currently granted for some materialized views in my database.",
			keyWords11, admin1);
	private Topic topic12 = new Topic("How to enable assembly bind failure logging (Fusion) in .NET",
			"How do I enable assembly bind failure logging (Fusion) in .NET?", keyWords12, admin1);
	private Topic topic13 = new Topic("Align two images in OpenCV", "I have two images (see below). ", keyWords13,
			admin1);
	private Topic topic14 = new Topic("Find integer solutions to a set of equations with more unkowns then equations",
			"I am trying to build a system for which I need to find a solution to a set of linear equations with (much) more variables then equations. ",
			keyWords14, admin1);
	private Topic topic15 = new Topic("Android custom notification not showing code changes",
			"There's some weird behavior here. I've got a bunch of code, pictures, followed by some description of the weird behavior and then my questions.",
			keyWords15, admin1);

	private Commentary comment1 = new Commentary(
			"Hardver je súhrnný názov pre technické vybavenie poèítaèa a poèítaèových komponentov.", admin1, topic1);
	private Commentary comment2 = new Commentary("Medzi hardvér patria všetky poèítaèe a ich súèasti.", admin1, topic1);
	private Commentary comment3 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic2);
	private Commentary comment4 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic3);
	private Commentary comment5 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic4);
	private Commentary comment6 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic5);
	private Commentary comment7 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic6);
	private Commentary comment8 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic7);
	private Commentary comment9 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic8);
	private Commentary comment10 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic9);
	private Commentary comment11 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic10);
	private Commentary comment12 = new Commentary(
			"In Postgres system catalogs are the basic set of complete information about the installation and databases.",
			user2, topic11);
	private Commentary comment13 = new Commentary(
			"If you already have logging enabled and you still get this error on Windows 7 64 bit, try this in IIS 7.5:",
			user2, topic12);
	private Commentary comment14 = new Commentary(
			"If these buttons are disabled, go back to the start menu, right-click the Log Viewer, and select Run as Administrator.",
			user2, topic12);
	private Commentary comment15 = new Commentary(
			"You just find solutions just like if it is a regular system, so you may possibly find infinetly many solutions:",
			admin1, topic14);
	private Commentary comment16 = new Commentary(
			"I would try the following approach (note that I never had to deal with that problem, so take this answer as an attempt to solve with you the problem instead of a real analytical answer).",
			admin1, topic14);
	private Commentary comment17 = new Commentary(
			"This is more likely to happen. The build has broken down and your built version of the app is not using the latest code. You can solve this by rebuilding the app from your IDE.",
			admin1, topic15);
	private Commentary comment18 = new Commentary(
			"The first of these could be that somewhere else in your code, you are refering to the creation of the notification, and there the changes you have made would not affect the code.",
			admin1, topic15);
	private Commentary comment19 = new Commentary(
			"Hardver je súhrnný názov pre technické vybavenie poèítaèa a poèítaèových komponentov.", admin1, topic3);
	private Commentary comment20 = new Commentary("Medzi hardvér patria všetky poèítaèe a ich súèasti.", admin1,
			topic15);
	private Commentary comment21 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic14);
	private Commentary comment22 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic13);
	private Commentary comment23 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic12);
	private Commentary comment24 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic11);
	private Commentary comment25 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic10);
	private Commentary comment26 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic9);
	private Commentary comment27 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic8);
	private Commentary comment28 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic7);
	private Commentary comment29 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic6);
	private Commentary comment30 = new Commentary(
			"In Postgres system catalogs are the basic set of complete information about the installation and databases.",
			admin1, topic5);
	private Commentary comment31 = new Commentary(
			"If you already have logging enabled and you still get this error on Windows 7 64 bit, try this in IIS 7.5:",
			admin1, topic4);
	private Commentary comment32 = new Commentary(
			"If these buttons are disabled, go back to the start menu, right-click the Log Viewer, and select Run as Administrator.",
			admin1, topic3);
	private Commentary comment33 = new Commentary(
			"You just find solutions just like if it is a regular system, so you may possibly find infinetly many solutions:",
			admin1, topic2);
	private Commentary comment34 = new Commentary(
			"I would try the following approach (note that I never had to deal with that problem, so take this answer as an attempt to solve with you the problem instead of a real analytical answer).",
			admin1, topic2);
	private Commentary comment35 = new Commentary(
			"This is more likely to happen. The build has broken down and your built version of the app is not using the latest code. You can solve this by rebuilding the app from your IDE.",
			admin1, topic1);
	private Commentary comment36 = new Commentary(
			"The first of these could be that somewhere else in your code, you are refering to the creation of the notification, and there the changes you have made would not affect the code.",
			admin1, topic1);
	private Commentary comment37 = new Commentary(
			"The first of these could be that somewhere else in your code, you are refering to the creation of the notification, and there the changes you have made would not affect the code.",
			admin1, topic8);
	private Commentary comment38 = new Commentary(
			"Hardver je súhrnný názov pre technické vybavenie poèítaèa a poèítaèových komponentov.", admin1, topic7);
	private Commentary comment39 = new Commentary("Medzi hardvér patria všetky poèítaèe a ich súèasti.", admin1,
			topic6);
	private Commentary comment40 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic1);
	private Commentary comment41 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic3);
	private Commentary comment42 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic2);
	private Commentary comment43 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic4);
	private Commentary comment44 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic12);
	private Commentary comment45 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic13);
	private Commentary comment46 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic14);
	private Commentary comment47 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic15);
	private Commentary comment48 = new Commentary("Softver je oznaèenie pre programové vybavenie poèítaèa", admin1,
			topic15);
	private Commentary comment49 = new Commentary(
			"In Postgres system catalogs are the basic set of complete information about the installation and databases.",
			admin1, topic3);
	private Commentary comment50 = new Commentary(
			"If you already have logging enabled and you still get this error on Windows 7 64 bit, try this in IIS 7.5:",
			admin1, topic9);
	private Commentary comment51 = new Commentary(
			"If these buttons are disabled, go back to the start menu, right-click the Log Viewer, and select Run as Administrator.",
			admin1, topic5);
	private Commentary comment52 = new Commentary(
			"You just find solutions just like if it is a regular system, so you may possibly find infinetly many solutions:",
			admin1, topic11);
	private Commentary comment53 = new Commentary(
			"I would try the following approach (note that I never had to deal with that problem, so take this answer as an attempt to solve with you the problem instead of a real analytical answer).",
			admin1, topic7);
	private Commentary comment54 = new Commentary(
			"This is more likely to happen. The build has broken down and your built version of the app is not using the latest code. You can solve this by rebuilding the app from your IDE.",
			admin1, topic6);
	private Commentary comment55 = new Commentary(
			"The first of these could be that somewhere else in your code, you are refering to the creation of the notification, and there the changes you have made would not affect the code.",
			admin1, topic10);

	/**
	 * Method for generate basic data in database
	 */
	public void generateDbs() {

		personService.registerPerson(removedPerson);
		personService.registerPerson(superAdmin);
		personService.registerPerson(admin1);
		personService.registerPerson(admin2);
		personService.registerPerson(admin3);
		personService.registerPerson(admin4);

		personService.registerPerson(user1);
		personService.registerPerson(user2);
		personService.registerPerson(user3);
		
		user1.setActive(true);
		user2.setActive(true);
		user3.setActive(true);
		
		personService.registerPerson(user4);
		personService.registerPerson(user5);
		personService.registerPerson(user6);

		keyWords1.add(new KeyWord("recyclerview"));
		keyWords1.add(new KeyWord("android-volley"));
		keyWords1.add(new KeyWord("recycler-adapter"));

		keyWords2.add(new KeyWord("eclipse"));
		keyWords2.add(new KeyWord("e4"));

		keyWords3.add(new KeyWord("wordpress"));
		keyWords3.add(new KeyWord("language-translation"));

		keyWords4.add(new KeyWord("ruby"));
		keyWords4.add(new KeyWord("initialization"));
		keyWords4.add(new KeyWord("arguments"));

		keyWords5.add(new KeyWord("python"));
		keyWords5.add(new KeyWord("datetime"));
		keyWords5.add(new KeyWord("pandas"));
		keyWords5.add(new KeyWord("cvs"));

		keyWords6.add(new KeyWord("ios"));
		keyWords6.add(new KeyWord("swift"));
		keyWords6.add(new KeyWord("uipangesturerecognizer"));
		keyWords6.add(new KeyWord("collectionview"));

		keyWords7.add(new KeyWord("c#"));
		keyWords7.add(new KeyWord("xml-serialization"));
		keyWords7.add(new KeyWord("codedom"));

		keyWords8.add(new KeyWord("android"));
		keyWords8.add(new KeyWord("google-analytics"));
		keyWords8.add(new KeyWord("enhanced-ecommerce"));

		keyWords9.add(new KeyWord("docker"));
		keyWords9.add(new KeyWord("docker-trusted-registry"));

		keyWords10.add(new KeyWord("java"));
		keyWords10.add(new KeyWord("spring-4"));
		keyWords10.add(new KeyWord("sesionfactory"));
		keyWords10.add(new KeyWord("hibernate-5.x"));
		keyWords10.add(new KeyWord("spring-orm"));

		keyWords11.add(new KeyWord("postgresql"));
		keyWords11.add(new KeyWord("privileges"));
		keyWords11.add(new KeyWord("information-schema"));

		keyWords12.add(new KeyWord("c#"));
		keyWords12.add(new KeyWord(".net"));
		keyWords12.add(new KeyWord("vb.net"));
		keyWords12.add(new KeyWord("binding"));
		keyWords12.add(new KeyWord("assemblies"));

		keyWords13.add(new KeyWord("opencv"));
		keyWords13.add(new KeyWord("image-processing"));
		keyWords13.add(new KeyWord("alignment"));

		keyWords14.add(new KeyWord("java"));
		keyWords14.add(new KeyWord("math"));
		keyWords14.add(new KeyWord("apache-commons-math"));

		keyWords12.add(new KeyWord("android"));
		keyWords12.add(new KeyWord("xml"));
		keyWords12.add(new KeyWord("android-layout"));

		topicService.addTopic(topic1);
		topicService.addTopic(topic2);
		topicService.addTopic(topic3);
		topicService.addTopic(topic4);
		topicService.addTopic(topic5);
		topicService.addTopic(topic6);
		topicService.addTopic(topic7);
		topicService.addTopic(topic8);
		topicService.addTopic(topic9);
		topicService.addTopic(topic10);
		topicService.addTopic(topic11);
		topicService.addTopic(topic12);
		topicService.addTopic(topic13);
		topicService.addTopic(topic14);
		topicService.addTopic(topic15);

		comment1.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment2.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment3.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment4.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment5.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment6.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment7.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment8.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment9.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment10.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment11.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment12.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment13.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment14.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment15.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment16.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment17.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));
		comment18.setCommentaryDate(new Date(System.currentTimeMillis() - 999999999));

		comment19.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment20.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment21.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment22.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment23.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment24.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment25.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment26.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment27.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment28.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment29.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment30.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment31.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment32.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment33.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment34.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment35.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));
		comment36.setCommentaryDate(new Date(System.currentTimeMillis() - 666666666));

		commentService.addComent(comment1);
		commentService.addComent(comment2);
		commentService.addComent(comment3);
		commentService.addComent(comment4);
		commentService.addComent(comment5);
		commentService.addComent(comment6);
		commentService.addComent(comment7);
		commentService.addComent(comment8);
		commentService.addComent(comment9);
		commentService.addComent(comment10);
		commentService.addComent(comment11);
		commentService.addComent(comment12);
		commentService.addComent(comment13);
		commentService.addComent(comment14);
		commentService.addComent(comment15);
		commentService.addComent(comment16);
		commentService.addComent(comment17);
		commentService.addComent(comment18);
		commentService.addComent(comment19);
		commentService.addComent(comment20);
		commentService.addComent(comment21);
		commentService.addComent(comment22);
		commentService.addComent(comment23);
		commentService.addComent(comment24);
		commentService.addComent(comment25);
		commentService.addComent(comment26);
		commentService.addComent(comment27);
		commentService.addComent(comment28);
		commentService.addComent(comment29);
		commentService.addComent(comment30);
		commentService.addComent(comment31);
		commentService.addComent(comment32);
		commentService.addComent(comment33);
		commentService.addComent(comment34);
		commentService.addComent(comment35);
		commentService.addComent(comment36);
		commentService.addComent(comment37);
		commentService.addComent(comment38);
		commentService.addComent(comment39);
		commentService.addComent(comment40);
		commentService.addComent(comment41);
		commentService.addComent(comment42);
		commentService.addComent(comment43);
		commentService.addComent(comment44);
		commentService.addComent(comment45);
		commentService.addComent(comment46);
		commentService.addComent(comment47);
		commentService.addComent(comment48);
		commentService.addComent(comment49);
		commentService.addComent(comment50);
		commentService.addComent(comment51);
		commentService.addComent(comment52);
		commentService.addComent(comment53);
		commentService.addComent(comment54);
		commentService.addComent(comment55);

		System.exit(0);
	}

	/**
	 * Method for drop all tables from database
	 */
	public void deleteTables() {
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
		query = em.createNativeQuery("drop table topic_person");
		query.executeUpdate();
		query = em.createNativeQuery("drop table Topic");
		query.executeUpdate();
		query = em.createNativeQuery("drop table Person");
		query.executeUpdate();
		JpaHelper.commitTransaction();
		System.exit(0);
	}

	public static void main(String[] args) {
		 GenerateBasicDbs gdbs = new GenerateBasicDbs();
//		 gdbs.generateDbs();
		 gdbs.deleteTables();
	}
}
