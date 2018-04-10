package rest;

import model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.NoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/rest/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping(path = "", method = GET)
    public List<Note> getAllNotes(
            @RequestParam(required = false) String boardId,
            @RequestParam(required = false) String username) {
        List<Note> notes = new ArrayList<>();
        noteRepository
                .findAll()
                .forEach(notes::add);

        if(boardId != null && !boardId.isEmpty()) {
            notes = notes
                    .stream()
                    .filter(note -> note.getBoardId().equals(boardId))
                    .collect(Collectors.toList());
        }

        if(username != null && !username.isEmpty()) {
            notes = notes
                    .stream()
                    .filter(note -> note.getUsername().equals(username))
                    .collect(Collectors.toList());
        }

        return notes;
    }

    @RequestMapping(path = "/{noteId}", method = GET)
    public Note getNote(@PathVariable String noteId) {
        return noteRepository.findById(noteId).orElse(null);
    }

    @RequestMapping(method = POST)
    public void addNote(@RequestBody Note note) {
        noteRepository.save(note);
    }

    @RequestMapping(path = "/{noteId}", method = PUT)
    public void updateNote(@RequestBody Note note, @PathVariable String noteId) {
        noteRepository.save(note);
    }

    @RequestMapping(method = DELETE)
    public void deleteAllNotes(
            @RequestParam(required = true) String boardId,
            @RequestParam(required = true) String username) {
        List<Note> notes = new ArrayList<>();
        noteRepository
                .findAll()
                .forEach(notes::add);

        notes = notes
                .stream()
                .filter(note -> note.getBoardId().equals(boardId))
                .collect(Collectors.toList());

        notes = notes
                .stream()
                .filter(note -> note.getUsername().equals(username))
                .collect(Collectors.toList());

        noteRepository.deleteAll(notes);
    }

    @RequestMapping(path = "/{noteId}", method = DELETE)
    public void deleteNote(@PathVariable String noteId) {
        noteRepository.deleteById(noteId);
    }

}
