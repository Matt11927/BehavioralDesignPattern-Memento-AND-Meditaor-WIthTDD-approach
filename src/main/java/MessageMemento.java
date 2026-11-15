import java.time.LocalDateTime;

public class MessageMemento {

    private String sender;
    private String content;
    private LocalDateTime timestamp;

    public MessageMemento( String sender , String content ){
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender(){ return sender; }

    public String getContent(){ return content; }

    public LocalDateTime getTimestamp(){ return timestamp; }
}
