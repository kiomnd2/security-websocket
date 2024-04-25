package test.application.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.domain.room.ChatRoomRepository;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomStore;

    public String createRoom(String roomNamm) {
        return chatRoomStore.createRoom(roomNamm);
    }

}
