package test.domain.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChatMessage {
    private Long roomId;
    private String sender;
    private String messageText;
    private MessageType messageType;

    public enum MessageType {
        TALK, ENTER
    }

}
