package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.services.PersonService;

public class PersonTest {

	PersonService ps = new PersonService();

	@Test
	public void testGetPersonByName() {
		Person person = ps.getPersonByName("Tomas");
		assertEquals("Tomas", person.getPersonName());
	}

	@Test
	public void testHashPassword() {
		int pass = ps.hashPassword("password");
		assertEquals(1216985755, pass);
	}

	@Test
	public void testGetPersonByNameAndPass() {
		Person person = ps.getPersonByNameAndPass("Tomas", 2101722548);
		assertEquals("Tomas", person.getPersonName());
		assertEquals(2101722548, person.getPassword());
	}

	/**
	 * Set person, which is not in table
	 */
	@Test
	public void testRegisterPerson() {
		String personName = "Milan";
		String pass = "HeSielk@475";
		String email = "kuceravymilan@centrum.sk";
		String fullName = "Milan Kudrna";
		Person person = new Person();
		person.setPersonName(personName);
		person.setPassword(ps.hashPassword(pass));
		person.setEmail(email);
		person.setFullName(fullName);
		ps.registerPerson(person);
		Person testPerson = ps.getPersonByName(personName);
		assertEquals("Milan", testPerson.getPersonName());
	}

}
