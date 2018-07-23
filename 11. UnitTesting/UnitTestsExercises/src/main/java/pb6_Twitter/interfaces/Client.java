package pb6_Twitter.interfaces;

public interface Client {

    void writeTweet(String message);

    void sendTweetToServer(String message);
}
