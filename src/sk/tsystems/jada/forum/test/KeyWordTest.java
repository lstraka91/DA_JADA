package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;
import javax.validation.constraints.NotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sk.tsystems.jada.forum.entity.KeyWord;
import sk.tsystems.jada.forum.entity.services.KeyWordService;

public class KeyWordTest {

	KeyWordService ks = new KeyWordService();
	TestService ts = new TestService();

	@Before
	public void beforeTesting() {
		ts.createPersons();
		ts.createKeyWords();
	}

	@After
	public void afterTesting() {
		ts.removePersons();
		ts.removekeyWords();
	}

	@Test
	public void testFindKeyWord() {
		String keyWord = "testKeyWord1";
		KeyWord k = ks.findKeyWord(keyWord);
		assertEquals(keyWord.toLowerCase(), k.getKeyWord());
	}

	@Test
	public void testGetAllKeyWords() {
		assertNotNull(ks.getAllKeyWords());
	}

	@Test
	public void testTopKeyWords() {
		assertNotNull(ks.topKeyWords());
	}

}
