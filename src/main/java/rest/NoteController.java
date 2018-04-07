package rest;

import model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.NoteRepository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(path = "", method = GET)
    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        noteRepository
                .findAll()
                .forEach(notes::add);
        return notes;
    }

}
