package test.interfaces.room;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.application.room.ChatRoomService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/room")
public class ChatRoomApi {
    private final ChatRoomService chatRoomService;

    @PostMapping
    public String createRoom(@RequestBody ChatRoomDto.createRoom roomDto) {
        return chatRoomService.createRoom(roomDto.getRoomName());
    }
}