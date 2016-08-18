package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jdk.net.NetworkPermission;
import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.Person;
import sk.tsystems.jada.forum.entity.SuperAdmin;
import sk.tsystems.jada.forum.entity.services.AdminService;
import sk.tsystems.jada.forum.entity.services.ChangePersonTypeService;
import sk.tsystems.jada.forum.entity.services.PersonService;

public class ChangePersonTypeTest {

	TestService ts = new TestService();
	ChangePersonTypeService chpts = new ChangePersonTypeService();
	PersonService ps = new PersonService();
	AdminService as = new AdminService();

	@Before
	public void beforeTesting() {
		ts.createPersons();
		ts.createAdmin();
	}

	@After
	public void afterTesting() {
		ts.removeAdmin();
		ts.removePersons();
	}

	@Test
	public void testChangePersonToAdmin() {
		String name = "TestPerson2";
		Person person = ps.getPersonByName(name);
		chpts.changePersonToAdmin(person);
		Admin admin = as.findAdminByName(name);
		assertEquals(name, admin.getPersonName());
	}

	@Test
	public void testChangePersonToSuperAdmin() {
		Person person = ps.getPersonByName("TestPerson2");
		chpts.changePersonToSuperAdmin(person);
		Person personChange = ps.getPersonByName("TestPerson2");
		SuperAdmin admin = (SuperAdmin) personChange;
		assertEquals(true, admin.isActivationUserPernmision());
		assertEquals(true, admin.isDeleteCommentPermission());
		assertEquals(true, admin.isDeleteTopicPermission());
		assertEquals(true, admin.isDeleteUserPermission());
	}

	@Test
	public void testChangeAdminToPerson() {
		String name = "TestPerson1";
		Admin admin = as.findAdminByName(name);
		chpts.changeAdminToPerson(admin);
		Person person = ps.getPersonByName(name);
		assertEquals(name, person.getPersonName());
		ts.createAdmin();
	}

}
