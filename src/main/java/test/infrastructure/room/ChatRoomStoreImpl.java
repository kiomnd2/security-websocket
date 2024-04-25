package test.infrastructure.room;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;
import test.domain.room.ChatRoom;
import test.domain.room.ChatRoomRepository;
import test.infrastructure.message.MessageSubscriber;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ChatRoomStoreImpl implements ChatRoomRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    private final String ROOM = "ROOM";
    private HashOperations<String, String, ChatRoom> hashOperations;
    private final RedisMessageListenerContainer messageListenerContainer;
    private final MessageSubscriber messageSubscriber;
    private Map<String, ChannelTopic> topicMap;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
        topicMap = new HashMap<>();
    }

    @Override
    public String createRoom(String roomName) {
        ChatRoom room = ChatRoom.createRoom(roomName);
        hashOperations.put(ROOM, room.getRoomId(), room);
        return room.getRoomId();
    }

    @Override
    public void enterRoom(String roomId) {
        ChannelTopic topic = topicMap.get(roomId);
        if (topic == null) {
            ChannelTopic channelTopic = new ChannelTopic(roomId);
            messageListenerContainer.addMessageListener(messageSubscriber, channelTopic);
            topicMap.put(roomId, channelTopic);
        }
    }

    @Override
    public ChannelTopic getTopic(String roomId) {
        return topicMap.get(roomId);
    }

}
