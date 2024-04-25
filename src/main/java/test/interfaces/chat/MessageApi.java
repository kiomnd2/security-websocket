package test.interfaces.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import test.domain.message.ChatMessage;
import test.domain.room.ChatRoomRepository;
import test.infrastructure.message.RedisMessagePublisher;

@RequiredArgsConstructor
@Controller
public class MessageApi {
    private final RedisMessagePublisher publisher;
    private final ChatRoomRepository repository;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER == message.getMessageType()) {
            repository.enterRoom(message.getRoomId());
            message.setMessageText(message.getSender() + "님이 입장하셨습니다.");
        }
        publisher.publish(repository.getTopic(message.getRoomId()), message);
    }
}
