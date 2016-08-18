package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sk.tsystems.jada.forum.entity.Admin;
import sk.tsystems.jada.forum.entity.services.AdminService;
import sk.tsystems.jada.forum.entity.services.PersonService;

public class AdminTest {
	
	TestService ts = new TestService();
	AdminService as = new AdminService();
	PersonService ps = new PersonService();
	
	@Before
	public void beforeTesting() {
		ts.createPersons();
		ts.createKeyWords();
		ts.createTopics();
		ts.createComments();
		ts.createRatings();
		ts.createAdmin();
	}

	@After
	public void afterTesting() {
		ts.removeAdmin();
		ts.removeRatings();
		ts.removeComments();
		ts.removeTopics();
		ts.removekeyWords();
		ts.removePersons();
	}

	@Test
	public void testShowAllAdmins() {
		ArrayList<Admin> list = as.showAllAdmins();
		assertNotNull(list);
		for (Admin admin : list) {
			assertEquals("TestPerson1", admin.getPersonName());
		}
	}
	
	@Test
	public void testPermissionUpdate() {
		Admin admin = as.findAdminByName("TestPerson1");
		as.permissionUpdate(admin, true, true, true, true);
		assertEquals(true, admin.isActivationUserPernmision());
		assertEquals(true, admin.isDeleteCommentPermission());
		assertEquals(true, admin.isDeleteTopicPermission());
		assertEquals(true, admin.isDeleteUserPermission());
	}
	
	@Test
	public void testFindAdminByName() {
		Admin admin = as.findAdminByName("TestPerson1");
		assertEquals("TestPerson1", admin.getPersonName());
	}

}
