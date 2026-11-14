import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private ChatServer server;
    private List<Message> receivedMessages;
    private ChatHistory chatHistory;
    public User( String username, ChatServer server){
        this.username = username;
        this.server = server;
        this.chatHistory = new ChatHistory();
        receivedMessages = new ArrayList<>();
    }

    public String getUsername(){ return username; }
    public void sendMessage( String content , List<String> recipients ){
        server.sendMessage(this , content , recipients);
        chatHistory.addMessage( new MessageMemento( content ) );
    }
    void setReceivedMessages( Message messages ){ receivedMessages.add( messages ); }
    public List<Message> getReceivedMessages(){ return receivedMessages; }

    public void undoLastMessage(){
        MessageMemento removedMessage = chatHistory.undoMessage();

        if( removedMessage != null ){
            System.out.println( "Undoing message: " + removedMessage.getContent() );
        }
    }

    public ChatHistory getChatHistory(){ return chatHistory; }
}
