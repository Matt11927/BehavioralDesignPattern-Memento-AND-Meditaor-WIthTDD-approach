import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main ( String [] args){

        ChatServer server = new ChatServer();

        User bruce = new User( "Bruce" , server );
        User ruby = new User( "Ruby" ,  server );
        User silvana = new User( "Silvana" , server );

        server.registerUser(bruce);
        server.registerUser(ruby);
        server.registerUser(silvana);

        System.out.println( " Message from one User to another " );
        bruce.sendMessage( "Hey Ruby, how have you been?" , List.of( "Ruby" ) );

        System.out.println( "\n A User sending a message to multiple Recipients " );
        bruce.sendMessage( "Ruby and Silvana, what time should we meet up?" , List.of( "Ruby" , "Silvana" ) );

        System.out.println( "\n Blocking User ");
        server.blockUser( "Ruby" , "Bruce" );
        System.out.println( "Ruby has blocked Bruce." );
        bruce.sendMessage( "Hey Ruby, Would you like to go get food with me?" , List.of( "Ruby" , "Silvana" ) );

        System.out.println( "\n Undo last message sent " );
        bruce.undoLastMessage();

        System.out.println( "\n Chat History " );
        System.out.println( "Bruce History Size: " + bruce.getChatHistory().getHistorySize() );
        bruce.getChatHistory().displayHistory();

        System.out.println( "\n Received Messages " );
        System.out.println( "Ruby Messages: " + ruby.getReceivedMessages().size() + " Message TimeStamps: " +ruby.getReceivedMessages().get(0).getTimestamp() );
        System.out.println( "Silvana Messages: " + silvana.getReceivedMessages().size() + " Message TimeStamps: " + silvana.getReceivedMessages().get(0).getTimestamp() );

        System.out.println( "\n Unregister User " );
        server.unregisterUser(silvana);
        System.out.println( "Silvana has been unregistered." );

        System.out.println( "\n Messages Sent By Bruce " );
        Iterator iterator = bruce.iterator( bruce );
        while ( iterator.hasNext() ) {
            MessageMemento message = ( MessageMemento ) iterator.next();
            System.out.println( message.getContent() );
        }
    }
}
