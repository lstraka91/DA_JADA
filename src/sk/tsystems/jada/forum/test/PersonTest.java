package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.JpaHelper;
import sk.tsystems.jada.forum.entity.services.PersonService;

public class PersonTest {

	PersonService ps = new PersonService();
	TestService ts = new TestService();

	@Before
	public void beforeTesting() {
		ts.createPersons();
	}

	@After
	public void afterTesting() {
		ts.removePersons();
	}

	@Test
	public void testGetPersonByName() {
		Person person = ps.getPersonByName("TestPerson1");
		assertEquals("TestPerson1", person.getPersonName());
	}

	@Test
	public void testGetPersonByNameAndPass() {
		Person person = ps.getPersonByNameAndPass("TestPerson1", "Password@123");
		assertEquals("TestPerson1", person.getPersonName());
		assertEquals("d00f5d5217896fb7fd601412cb890830", person.getPassword());
	}

	/**
	 * Set person, which is not in table
	 */
	@Test
	public void testRegisterPerson() {
		String personName = "TestPerson3";
		String pass = "passwORD@478";
		String email = "TestPerson3@mail.com";
		String fullName = "TestPerson3 Fullname";
		Person person = new Person();
		person.setPersonName(personName);
		person.setPassword(pass);
		person.setEmail(email);
		person.setFullName(fullName);
		ps.registerPerson(person);
		Person testPerson = ps.getPersonByName(personName);
		assertEquals("TestPerson3", testPerson.getPersonName());
	}

	@Test
	public void testUpdatePersonProfile() {
		Person person = new Person();
		person.setEmail("newmail@mail.com");
		person.setFullName("New FullName");
		ps.updatePersonProfile(ps.getPersonByName("TestPerson1"), person);
		assertEquals("newmail@mail.com", ps.getPersonByName("TestPerson1").getEmail());
		assertEquals("New FullName", ps.getPersonByName("TestPerson1").getFullName());
	}

//	@Test
//	public void testChangePersonPassword() {
//		Person person = ps.getPersonByName("TestPerson1");
//		ps.changePersonPassword(person, "SuperUltraNewPass@@478");
//		assertEquals(PersonService.encryptPassword("SuperUltraNewPass@@478"), ps.getPersonByName("TestPerson1").getPassword());
//	}

	@Test
	public void testEncryprPassword() {
		String pass = ps.encryptPassword("PassWorD@963");
		assertEquals("c04c944759d3d3b52b29ca70c638d976", pass);
	}

}
