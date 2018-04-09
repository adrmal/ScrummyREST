package rest;

import model.BoardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.BoardUserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/users")
public class BoardUserController {

    @Autowired
    private BoardUserRepository boardUserRepository;

    @RequestMapping(path = "", method = GET)
    public List<BoardUser> getAllBoardUsers() {
        List<BoardUser> boardUsers = new ArrayList<>();
        boardUserRepository
                .findAll()
                .forEach(boardUsers::add);
        return boardUsers;
    }

}
