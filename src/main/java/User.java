import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private ChatServer server;
    private List<Message> receivedMessages;
    public User( String username, ChatServer server){
        this.username = username;
        this.server = server;
        receivedMessages = new ArrayList<>();
    }

    public String getUsername(){ return username; }
    public void sendMessage( String content , List<String> recipients ){
        server.sendMessage(this , content , recipients);
    }
    void setReceivedMessages( Message messages ){ receivedMessages.add( messages ); }
    public List<Message> getReceivedMessages(){ return receivedMessages; }

}
