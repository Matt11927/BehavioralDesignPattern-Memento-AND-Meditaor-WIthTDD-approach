import java.util.*;

public class ChatServer {

    private Map<String, User> users;
    private Map<String, Set<String>> blockedUsers;

    public ChatServer() {
        users = new HashMap<>();
        blockedUsers = new HashMap<>();
    }

    public void registerUser(User user) { users.put( user.getUsername(), user );  }

    public void blockUser( String blocker , String blockedUser ){
        blockedUsers.computeIfAbsent( blocker , k -> new HashSet<>() ).add( blockedUser );
    }

    public void sendMessage( User sender , String content, List<String> recipients ) {
        for ( String recipient : recipients ) {
            User user = users.get( recipient );
            if ( user != null ) {
                boolean isBlocked = blockedUsers.containsKey( recipient ) && blockedUsers.get( recipient ).contains( sender.getUsername() );

               if( !isBlocked ) {
                   Message message = new Message(sender.getUsername(), content);
                   user.setReceivedMessages(message);
               }
            }
        }
    }


}