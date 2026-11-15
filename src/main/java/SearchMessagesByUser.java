import java.util.Iterator;
import java.util.Stack;

public class SearchMessagesByUser implements Iterator<MessageMemento> {

    private int index;
    private Stack<MessageMemento> history;
    private User userToSearchWith;
    public SearchMessagesByUser( ChatHistory chatHistory , User userToSearchWith ){
        this.history = chatHistory.getHistory();
        this.userToSearchWith = userToSearchWith;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        while ( index < history.size() ) {
            MessageMemento message = history.get( index );
            if ( message.getSender().equals( userToSearchWith.getUsername() ) ) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public MessageMemento next() {
        if ( hasNext() ) {
            return history.get( index++ );
        }
        return null;
    }
}
