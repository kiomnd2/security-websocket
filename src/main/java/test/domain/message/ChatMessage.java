package test.domain.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ChatMessage {
    private String roomId;
    private String sender;
    private String messageText;
    private MessageType messageType;

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public enum MessageType {
        TALK, ENTER
    }

}
