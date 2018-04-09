package rest;

import model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.ChatMessageRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @RequestMapping(path = "", method = GET)
    public List<ChatMessage> getAllChatMessages() {
        List<ChatMessage> chatMessages = new ArrayList<>();
        chatMessageRepository
                .findAll()
                .forEach(chatMessages::add);
        return chatMessages;
    }

}
