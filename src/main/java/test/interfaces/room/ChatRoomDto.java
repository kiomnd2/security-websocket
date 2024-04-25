package test.interfaces.room;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ChatRoomDto {

    @Getter
    @Setter
    @ToString
    public static class createRoom {
        private String roomName;
    }

}
