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

@RestController
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("notes")
    
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }


    @GetMapping("note/{id}")
    
    public Notes getNoteById(@PathVariable("id") Integer id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("note")
 
    public void updateNote(@RequestBody Notes note) {
        noteService.updateNote(note);
    }

    @DeleteMapping("note/{id}")
   
    public void  deleteNote(@PathVariable("id") Integer id) {
        noteService.deleteNote(id);
    }

    @PostMapping("note")
    
    public void addNote(@RequestBody Notes note) {
        noteService.addNote(note);
    }
}
