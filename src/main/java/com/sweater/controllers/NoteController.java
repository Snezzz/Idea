package com.sweater.controllers;

import com.sweater.entities.Notes;
import com.sweater.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("notes")
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("note/{id}")
    public Notes getNoteById(@PathVariable("id") Integer id) {
        return noteService.getNoteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("note")
    public void updateNote(@RequestBody Notes note) {
        noteService.updateNote(note);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("note/{id}")
    public void  deleteNote(@PathVariable("id") Integer id) {
        noteService.deleteNote(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("note")
    public void addNote(@RequestBody Notes note) {
        noteService.addNote(note);
    }
}
