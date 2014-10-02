package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.Tweet;
import android.test.ActivityInstrumentationTestCase2;

public class AbstractTweetTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public AbstractTweetTest() {
		super(LonelyTwitterActivity.class);		
	}
	
	public void testFiveisFive() {
		assertEquals("Five is Five", 5, 5);
	}
	
	public void testAbstractTweetequalsMethod() { //written on own
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("hello");
		assertFalse("Tweet1 and Tweet2 is equal", t.equals(t2));
		Tweet t3 = new Tweet("Hello");
		assertTrue("Tweet1 and T3 not equal", t.equals(t3));
		assertFalse("T2 and t3 equal", t2.equals(t3));
		assertFalse("T3 T2 equal", t3.equals(t2));
		assertTrue("T3 T1 not equal", t3.equals(t));
	}
	
	public void testAbstractTweet() { //written from lab
		Tweet t = new Tweet("Hello");
		Tweet t2 = new Tweet("Hello");
		String actual = t.getTweetBody();
		assertEquals("Tweet body is not the same", "Hello", actual);
		//assertSame("Same tweets", t, t2); //this is checking points to same object
		assertEquals("Same tweets", t,t2);
	}
}
