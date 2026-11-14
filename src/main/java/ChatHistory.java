import java.util.Stack;

public class ChatHistory {

    private Stack<MessageMemento> history;

    public ChatHistory(){ history = new Stack<>(); }

    public void addMessage( MessageMemento memento ){ history.push( memento ); }

    public MessageMemento undoMessage(){
        if( !history.isEmpty() ){ return history.pop(); }
        return null;
    }

    public int getHistorySize(){ return history.size(); }

}
