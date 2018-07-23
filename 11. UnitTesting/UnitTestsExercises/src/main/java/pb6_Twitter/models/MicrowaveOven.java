package pb6_Twitter.models;

import pb6_Twitter.interfaces.Client;
import pb6_Twitter.interfaces.RepositoryTweets;
import pb6_Twitter.interfaces.Writer;

public class MicrowaveOven implements Client {
    private Writer writer;
    private RepositoryTweets repositoryTweets;

    public MicrowaveOven(Writer writer, RepositoryTweets repositoryTweets) {
        this.writer = writer;
        this.repositoryTweets = repositoryTweets;
    }


    public void writeTweet(String message) {
        this.writer.writeLine(message);

    }


    public void sendTweetToServer(String message) {
        this.repositoryTweets.saveTweet(message);
    }
}
