import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatAppTest {


    @Test
    void testSendMessage(){
        ChatServer server = new ChatServer();

        User bruce = new User("Bruce",server);
        User ruby = new User("Ruby",server);

        server.registerUser(bruce);
        server.registerUser(ruby);

        bruce.sendMessage("Hey Ruby how have you been?", List.of("Ruby"));

        int expectedMessages = 1;
        int actualMessages = ruby.getReceivedMessages().size();

        assertEquals(expectedMessages,actualMessages);
    }

    @Test
    void testSendMessageToMultipleRecipients() {

        ChatServer server = new ChatServer();

        User bruce = new User( "Bruce" , server );
        User ruby = new User( "Ruby" , server );
        User silvana  = new User( "Silvana" , server );

        server.registerUser( bruce );
        server.registerUser( ruby );
        server.registerUser( silvana );

        bruce.sendMessage( "Ruby and Silvana what times should we meet up?" , List.of( "Ruby" , "Silvana" ) );

        int expectedMessages = 1;
        int actualRubyMessages = ruby.getReceivedMessages().size();
        int actualSilvanaMessages = silvana.getReceivedMessages().size();

        assertEquals( expectedMessages , actualRubyMessages );
        assertEquals( expectedMessages , actualSilvanaMessages );
    }



    @Test
    void testMessageSavedToHistory() {

        ChatServer server = new ChatServer();

        User bruce = new User( "Bruce" , server );
        User ruby = new User( "Ruby" , server );

        server.registerUser( bruce );
        server.registerUser( ruby );

        bruce.sendMessage( "Hey Ruby was wondering if you want to go out sometime?" , List.of( "Ruby" ) );

        int expectedMessages = 1;
        int actualMessages = bruce.getChatHistory().getHistorySize();

        assertEquals( expectedMessages , actualMessages );
    }


    @Test
    void testUndoLastMessage() {

        ChatServer server = new ChatServer();

        User bruce = new User( "Bruce" , server );
        User ruby = new User( "Ruby" , server );

        server.registerUser( bruce );
        server.registerUser( ruby );

        bruce.sendMessage( "Hello Ruby" , List.of( "Ruby" ) );
        bruce.sendMessage( "Are you free tomorrow?" , List.of( "Ruby" ) );

        bruce.undoLastMessage();

        int expectedMessages = 1;
        int actualMessage = bruce.getChatHistory().getHistorySize();

        assertEquals( expectedMessages , actualMessage );
    }

    @Test
    void testBlockedUserMessages() {

        ChatServer server = new ChatServer();

        User bruce = new User("Bruce", server);
        User ruby = new User("Ruby", server);

        server.registerUser(bruce);
        server.registerUser(ruby);

        server.blockUser("Ruby", "Bruce");

        bruce.sendMessage( "Hey Ruby, Would you like to go get food with me?" , List.of( "Ruby" ) );

        int expectedMessage = 0;
        int actualMessage = ruby.getReceivedMessages().size();

        assertEquals( expectedMessage , actualMessage );
    }



}
