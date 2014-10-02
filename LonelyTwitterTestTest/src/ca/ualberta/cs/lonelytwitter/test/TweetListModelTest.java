package ca.ualberta.cs.lonelytwitter.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.util.Log;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;
import junit.framework.TestCase;

public class TweetListModelTest extends TestCase {
	
	public void testHasTweetMethod(){
		Tweet t = new Tweet("Goodmorning");
		TweetListModel list = new TweetListModel();
		assertFalse("List doesn't have tweet", list.hasTweet(t));
		list.addTweet(t);
		boolean b = list.hasTweet(t);
		assertTrue("list has tweet", b);
		List<AbstractTweet> list2 = list.getList();
		assertTrue("list2 has tweet", list2.contains(t));
		assertEquals("boolean not equals", list2.contains(t), b);
	}
	
	public void testRemoveTweets(){
		Tweet t = new Tweet("Goodmorning");
		TweetListModel list = new TweetListModel();
		list.addTweet(t);
		assertTrue("list added tweet", list.hasTweet(t));
		list.removeTweet(t);
		assertFalse("list does not have tweet", list.hasTweet(t));
		
	}
	public void testgetCount(){
		Tweet t = new Tweet("Goodmorning");
		TweetListModel list =  new TweetListModel();
		list.addTweet(t);
		List<AbstractTweet> list2 = list.getList();
		int sizeoflist = list2.size();
		assertEquals("size is equal", sizeoflist, list.getCount());
		Tweet t2 = new Tweet("Goodmorning2");
		list.addTweet(t2);
		assertFalse("size is not equal", sizeoflist == list.getCount());
		list2.add(t2); 
		sizeoflist = list2.size();
		assertEquals("size is equal", sizeoflist, list.getCount());
	}
	
	public void testSortedlist(){
		Tweet t = new Tweet("b");
		Tweet t2 = new Tweet("a");
		Tweet t3 = new Tweet("c");
		TweetListModel list = new TweetListModel();
		list.addTweet(t);
		list.addTweet(t2);
		list.addTweet(t3);
		AbstractTweet[] array= new AbstractTweet[3];
		array = list.getTweets();
		assertTrue("t > t2", array[0].getTweetBody().compareTo(array[1].getTweetBody())<0);
		assertTrue("t2 > t3", array[1].getTweetBody().compareTo(array[2].getTweetBody())<0);
	}
	
	public void testDuplicates(){
		Tweet t= new Tweet("hello");
		Tweet t2 = new Tweet("hello");
		TweetListModel list = new TweetListModel();
		list.addTweet(t);
		list.addTweet(t2);
		assertTrue("did not add", list.getCount() == 1);
	}
}
