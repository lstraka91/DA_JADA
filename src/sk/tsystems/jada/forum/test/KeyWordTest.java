package sk.tsystems.jada.forum.test;

import static org.junit.Assert.*;
import javax.validation.constraints.NotNull;

import org.junit.Test;

import sk.tsystems.jada.forum.entity.KeyWord;
import sk.tsystems.jada.forum.entity.services.KeyWordService;

public class KeyWordTest {

	KeyWordService ks = new KeyWordService();

	@Test
	public void testFindKeyWord() {
		String keyWord = "java";
		KeyWord k = ks.findKeyWord(keyWord);
		assertEquals(keyWord, k.getKeyWord());
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
