package pb6_Twitter;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;
import pb6_Twitter.interfaces.Client;
import pb6_Twitter.interfaces.Tweet;
import pb6_Twitter.models.Message;

public class TweetTests {

    private static final String EXAMPLE_TEXT="Test";
    @Test
    public void ReceiveMessageShouldInvokeItsClientToWriteTheMessage(){

        Tweet tweet=Mockito.mock(Message.class);
        tweet.receiveMessage(EXAMPLE_TEXT);

        Mockito.verify(tweet,Mockito.times(1)).receiveMessage(EXAMPLE_TEXT);

    }
    @Test
    public void ReceiveMessageShouldInvokeItsClientToSendTheMessageToTheServer(){
        Client client=Mockito.mock(Client.class);
        Tweet tweet=new Message(client);
        tweet.receiveMessage(EXAMPLE_TEXT);

        Mockito.verify(client,Mockito.times(1)).sendTweetToServer(EXAMPLE_TEXT);
    }
}
