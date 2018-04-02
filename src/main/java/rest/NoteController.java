package rest;

import model.Note;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/rest")
public class NoteController {

    private static List<Note> notes;

    static {
        notes = new ArrayList<>();
        Note note1 = new Note();
        note1.setTitle("title1");
        note1.setContent("content1");
        Note note2 = new Note();
        note2.setTitle("title2");
        note2.setContent("content2");
        notes.add(note1);
        notes.add(note2);
    }

    @RequestMapping(path = "/notes", method = RequestMethod.GET)
    public List<Note> getAllNotes() {
        return notes;
    }

}
