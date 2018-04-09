package persistence;

import model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
}
