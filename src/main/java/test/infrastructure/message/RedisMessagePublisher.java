package test.infrastructure.message;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;
import test.domain.message.ChatMessage;

@RequiredArgsConstructor
@Component
public class RedisMessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(ChannelTopic channelTopic, ChatMessage chatMessage) {

    }
}
