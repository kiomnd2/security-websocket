package test.handler;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

import java.nio.file.AccessDeniedException;

public class StompHandler implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        // 연결 시
        if (accessor.getCommand() == StompCommand.CONNECT) {
            throw new RuntimeException("인증 오류");
        }

        return message;
    }
}
