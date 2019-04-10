package com.sweater.controllers;

import com.sweater.entities.Notes;
import com.sweater.repositories.NotesRepository;
import com.sweater.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("notes")
    public ResponseEntity<List<Notes>> getAllNotes() {
        List<Notes> list = noteService.getAllNotes();
        return new ResponseEntity<List<Notes>>(list, HttpStatus.OK);
    }


    @GetMapping("note/{id}")
    public ResponseEntity<Notes> getNoteById(@PathVariable("id") Integer id) {
        Notes article = noteService.getNoteById(id);
        return new ResponseEntity<Notes>(article, HttpStatus.OK);
    }

    @PutMapping("note")
    public ResponseEntity<Notes> updateNote(@RequestBody Notes article) {
        noteService.updateNote(article);
        return new ResponseEntity<Notes>(article, HttpStatus.OK);
    }

    @DeleteMapping("note/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Integer id) {
        noteService.deleteNote(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("note")
    public ResponseEntity<Notes> addNote(@RequestBody Notes note) {
        noteService.addNote(note);
        return new ResponseEntity<Notes>(note, HttpStatus.OK);



    }
}
