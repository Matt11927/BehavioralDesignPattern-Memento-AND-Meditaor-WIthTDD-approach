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

}
