package sk.tsystems.jada.forum;

import java.util.Date;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.PersonService;

public class MainTest {

	public static void main(String[] args) {

		Person person = new Person("jozefko", "12345", "jozo@jozo.sk", new Date(System.currentTimeMillis() - 150000));

		new PersonService().registerPerson(person);

	}

}
