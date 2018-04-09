package persistence;

import model.BoardUser;
import org.springframework.data.repository.CrudRepository;

public interface BoardUserRepository extends CrudRepository<BoardUser, Long> {
}
