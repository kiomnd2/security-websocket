package test.domain.room;

import org.springframework.data.redis.listener.ChannelTopic;

public interface ChatRoomRepository {
    String createRoom(String roomName);
    void enterRoom(String roomId);

    ChannelTopic getTopic(String roomId);
}
