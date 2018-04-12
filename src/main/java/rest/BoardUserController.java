package rest;

import model.BoardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.BoardUserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/users")
public class BoardUserController {

    @Autowired
    private BoardUserRepository boardUserRepository;

    @RequestMapping(path = "", method = GET)
    public List<BoardUser> getAllBoardUsers(
            @RequestParam(required = false) String boardId,
            @RequestParam(required = false) String username,
            @RequestParam(name = "role", required = false) String[] roles) {
        List<BoardUser> users = new ArrayList<>();
        boardUserRepository
                .findAll()
                .forEach(users::add);

        if(boardId != null && !boardId.isEmpty()) {
            users = users
                    .stream()
                    .filter(user -> user.getBoardId().equals(boardId))
                    .collect(Collectors.toList());
        }

        if(username != null && !username.isEmpty()) {
            users = users
                    .stream()
                    .filter(user -> user.getUsername().equals(username))
                    .collect(Collectors.toList());
        }

        if(roles != null && roles.length > 0) {
            users = users
                    .stream()
                    .filter(user -> new ArrayList<>(Arrays.asList(roles)).contains(user.getUserRole().toString()))
                    .collect(Collectors.toList());
        }

        return users;
    }

    @RequestMapping(method = POST)
    public void addBoardUser(@RequestBody BoardUser user) {
        boardUserRepository.save(user);
    }

    @RequestMapping(path = "/{userId}", method = PUT)
    public void updateBoardUser(@RequestBody BoardUser user, @PathVariable String userId) {
        boardUserRepository.save(user);
    }

}
