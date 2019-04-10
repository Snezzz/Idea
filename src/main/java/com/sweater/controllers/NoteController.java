package com.sweater.controllers;

import com.sweater.entities.Notes;
import com.sweater.repositories.NotesRepository;
import com.sweater.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/notes")
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }


    @GetMapping("/noteById")
    public Notes getNoteById(@RequestBody int id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/note")
    public void addNote(@RequestBody Notes note) {
        noteService.addNote(note);
    }

    @PutMapping("note")
    public void updateNote(@RequestBody Notes note) {
        noteService.updateNote(note);
    }


    @DeleteMapping("/noteById")
    public void deleteNote(@RequestBody int id) {
        noteService.deleteNote(id);
    }

}
