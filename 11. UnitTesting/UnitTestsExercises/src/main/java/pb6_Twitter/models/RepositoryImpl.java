package pb6_Twitter.models;

import pb6_Twitter.interfaces.RepositoryTweets;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements RepositoryTweets {
    private List<String> tweets;

    public RepositoryImpl() {
        this.tweets=new ArrayList<>();
    }


    public void saveTweet(String content) {
        this.tweets.add(content);
    }
}
