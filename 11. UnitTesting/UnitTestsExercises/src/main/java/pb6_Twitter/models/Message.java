package pb6_Twitter.models;

import pb6_Twitter.interfaces.Client;
import pb6_Twitter.interfaces.Tweet;

public class Message implements Tweet {
    private Client client;

    public Message(Client client) {
        this.client = client;
    }

    @Override
    public void receiveMessage(String message) {
        this.client.writeTweet(message);
        this.client.sendTweetToServer(message);
    }
}
