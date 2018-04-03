package rest;

import model.Note;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/notes")
public class NoteController {

    private static List<Note> notes;

    static {
        notes = new ArrayList<>();
        Note note1 = new Note();
        note1.setTitle("title of first example note");
        note1.setContent("example content which is made for example only");
        Note note2 = new Note();
        note2.setTitle("this is the example note");
        note2.setContent("the example notes should be removed when the database will be ready");
        notes.add(note1);
        notes.add(note2);
    }

    @RequestMapping(path = "", method = GET)
    public List<Note> getAllNotes() {
        return notes;
    }

}
