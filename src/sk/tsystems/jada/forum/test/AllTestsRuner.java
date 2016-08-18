package sk.tsystems.jada.forum.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminTest.class, CommentaryTest.class, CommentWithRatingTest.class, ChangePersonTypeTest.class,
		KeyWordTest.class, PersonTest.class, RatingTest.class, TopicTest.class })
public class AllTestsRuner {

}
