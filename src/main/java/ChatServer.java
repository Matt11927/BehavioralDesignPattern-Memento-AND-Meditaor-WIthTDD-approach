import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {

    private Map<String, User> users;

    public ChatServer() { users = new HashMap<>(); }

    public void registerUser(User user) { users.put( user.getUsername(), user );  }

    public void sendMessage( User sender , String content, List<String> recipients ) {
        for ( String recipient : recipients ) {
            User user = users.get( recipient );
            if ( user != null ) {
                Message message = new Message( sender.getUsername() , content );
                user.setReceivedMessages(message);
            }
        }
    }
}