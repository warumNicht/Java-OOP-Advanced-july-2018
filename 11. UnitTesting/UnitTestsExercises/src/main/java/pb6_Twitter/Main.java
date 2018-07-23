package pb6_Twitter;

import pb6_Twitter.interfaces.Client;
import pb6_Twitter.interfaces.RepositoryTweets;
import pb6_Twitter.interfaces.Tweet;
import pb6_Twitter.interfaces.Writer;
import pb6_Twitter.models.ConsoleWriterImpl;
import pb6_Twitter.models.Message;
import pb6_Twitter.models.MicrowaveOven;
import pb6_Twitter.models.RepositoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Writer writer=new ConsoleWriterImpl();
        RepositoryTweets repo=new RepositoryImpl();

        Client client=new MicrowaveOven(writer,repo);
        Tweet tweet=new Message(client);

        String input=reader.readLine();

        while ("End".equals(input)==false){

            tweet.receiveMessage(input);

            input=reader.readLine();
        }



    }
}
