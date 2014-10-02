package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.R.array;
import android.util.Log;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.Tweet;

public class TweetListModel {

	private List<AbstractTweet> tweets = new ArrayList<AbstractTweet>();

	public TweetListModel() {
	}
	
	public TweetListModel(List<AbstractTweet> tweets) {
		this.tweets = tweets;
	}

	/**
	 * Appends the specified tweet to the end of this list. Throws
	 * IllegalArgumentException if it is a repeated tweet.
	 * 
	 * @param tweet
	 *            Tweet to be appended to this list
	 */
	public void addTweet(AbstractTweet tweet) {
		boolean b =false;
		for(int i=0; i<tweets.size(); i++){
			if(tweets.get(i).equals(tweet)){
				b = true;
				throw new IllegalArgumentException("ERROR");
			}
		}
		// TODO: Add only when it is not a duplicate
		if(b==false){
			tweets.add(tweet);
		}
	}

	/**
	 * Returns the number of tweets in this list.
	 * 
	 * @return the number of tweets in this list
	 */
	public int getCount() {
		return tweets.size();
	}

	/**
	 * Returns true if this list contains the tweet
	 * 
	 * @param tweet
	 *            Tweet whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean hasTweet(AbstractTweet tweet) {
		return tweets.contains(tweet);
	}

	/**
	 * Removes the first occurrence of the specified tweet from this list, if it
	 * is present.
	 * 
	 * @param tweet
	 *            Tweet to be removed from this list, if present.
	 */
	public void removeTweet(AbstractTweet tweet) {
		tweets.remove(tweet);
	}

	/**
	 * Returns an array containing all of the tweets in this list in proper
	 * sequence.
	 * 
	 * @return an array containing the tweets of the list.
	 */
	public AbstractTweet[] getTweets() {
//		ArrayList<AbstractTweet> tweets2 = new ArrayList<AbstractTweet>();
//		int newsize = tweets.size();
//		ArrayList<AbstractTweet> clonetweets = new ArrayList<AbstractTweet>(tweets);
//		while(newsize  0){
//			AbstractTweet smallest = tweets.get(0);
//			for(int i=1; i<newsize;i++){
//				String s = clonetweets.get(i).getTweetBody();
//				Log.v("This", s);
//				if (smallest.getTweetBody().compareTo(clonetweets.get(i).getTweetBody())<0){
//					smallest = clonetweets.get(i);
//				}
//			}
//			tweets2.add(smallest);
//			clonetweets.remove(smallest);
//			newsize--;
//		}
		Collections.sort(tweets, new Comparator<AbstractTweet>(){
			//@Override
			public int compare(AbstractTweet tweet1, AbstractTweet tweet2){
				return tweet1.getTweetBody().compareTo(tweet2.getTweetBody());
			}			
		});
		AbstractTweet[] tweetarray = new AbstractTweet[tweets.size()];
		return tweets.toArray(tweetarray);
		//return tweetarray;
		
	}

	/**
	 * Returns the list of tweets.
	 * 
	 * @return The list of tweets.
	 */
	public List<AbstractTweet> getList() {
		return tweets;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after
	 * this call returns.
	 */
	public void clear() {
		tweets.clear();
	}
}