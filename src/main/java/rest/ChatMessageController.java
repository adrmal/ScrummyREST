package rest;

import model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import persistence.ChatMessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/messages")
public class ChatMessageController {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @RequestMapping(path = "", method = GET)
    public List<ChatMessage> getAllChatMessages(
            @RequestParam(required = false) String boardId,
            @RequestParam(required = false) String username1,
            @RequestParam(required = false) String username2,
            @RequestParam(required = false) String jiraUrl) {
        List<ChatMessage> messages = new ArrayList<>();
        chatMessageRepository
                .findAll()
                .forEach(messages::add);

        if(boardId != null && !boardId.isEmpty()) {
            messages = messages
                    .stream()
                    .filter(message -> message.getBoardId().equals(boardId))
                    .collect(Collectors.toList());
        }

        if(username1 != null && !username1.isEmpty()) {
            messages = messages
                    .stream()
                    .filter(message -> message.getUsernameFrom().equals(username1) || message.getUsernameTo().equals(username1))
                    .collect(Collectors.toList());
        }

        if(username2 != null && !username2.isEmpty()) {
            messages = messages
                    .stream()
                    .filter(message -> message.getUsernameFrom().equals(username2) || message.getUsernameTo().equals(username2))
                    .collect(Collectors.toList());
        }

        if(jiraUrl != null && !jiraUrl.isEmpty()) {
            messages = messages
                    .stream()
                    .filter(message -> message.getJiraUrl().equals(jiraUrl))
                    .collect(Collectors.toList());
        }

        return messages;
    }

    @RequestMapping(method = POST)
    public ChatMessage addChatMessage(@RequestBody ChatMessage message) {
        return chatMessageRepository.save(message);
    }

}
