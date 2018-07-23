package pb6_Twitter;

import org.junit.Test;
import org.mockito.Mockito;
import pb6_Twitter.interfaces.Client;
import pb6_Twitter.interfaces.RepositoryTweets;
import pb6_Twitter.interfaces.Writer;
import pb6_Twitter.models.MicrowaveOven;

public class MicroOndesTest {
    private static final String EXAMPLE_TEXT="Test";
    @Test
    public void SendTweetToServerShouldSendTheMessageToItsServer(){
        RepositoryTweets repo=Mockito.mock(RepositoryTweets.class);
        Writer writer=Mockito.mock(Writer.class);

        Client ondes=new MicrowaveOven(writer,repo);

        ondes.sendTweetToServer(EXAMPLE_TEXT);

        Mockito.verify(repo,Mockito.times(1)).saveTweet(EXAMPLE_TEXT);
    }
    @Test
    public void WriteTweetShouldCallItsWriterWithTheTweetsMessage(){
        RepositoryTweets repo=Mockito.mock(RepositoryTweets.class);
        Writer writer=Mockito.mock(Writer.class);

        Client ondes=new MicrowaveOven(writer,repo);

        ondes.writeTweet(EXAMPLE_TEXT);

        Mockito.verify(writer,Mockito.times(1)).writeLine(EXAMPLE_TEXT);
    }
}
