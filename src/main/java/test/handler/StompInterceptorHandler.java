package test.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;
import test.domain.member.TokenProvider;

@RequiredArgsConstructor
@Component
public class StompInterceptorHandler implements ChannelInterceptor {
    private final TokenProvider tokenProvider;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        // 연결 시
        if (accessor.getCommand() == StompCommand.CONNECT) {
            String jwtToken = accessor.getFirstNativeHeader("token");
            String t = tokenProvider.validToken(jwtToken);
            if (t == null) {
                throw new RuntimeException("인증 오류");
            }
        }

        return message;
    }
}
