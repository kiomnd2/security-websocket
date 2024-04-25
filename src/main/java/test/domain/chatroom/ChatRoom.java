package test.domain.chatroom;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class ChatRoom {

    private String roomId;
    private String name;

    @Builder
    public ChatRoom(String name) {
        this.roomId = UUID.randomUUID().toString();
        this.name = name;
    }

    public static ChatRoom createRoom(String roomName) {
        return ChatRoom.builder()
                .name(roomName)
                .build();
    }
}
