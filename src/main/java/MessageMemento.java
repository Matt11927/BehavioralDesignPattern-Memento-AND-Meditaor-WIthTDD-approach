import java.time.LocalDateTime;

public class MessageMemento {

    private String content;
    private LocalDateTime timestamp;

    public MessageMemento( String content ){
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent(){ return content; }

    public LocalDateTime getTimestamp(){ return timestamp; }
}
