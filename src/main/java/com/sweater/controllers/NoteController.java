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
    @ResponseBody
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }


    @GetMapping("noteById/{id}")
    @ResponseBody
    public Notes getNoteById(@PathVariable("id") Integer id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("note")
    @ResponseBody
    public void updateNote(@RequestBody Notes note) {
        noteService.updateNote(note);
    }

    @DeleteMapping("noteById/{id}")
    @ResponseBody
    public void  deleteNote(@PathVariable("id") Integer id) {
        noteService.deleteNote(id);
    }

    @PostMapping("note")
    @ResponseBody
    public void addNote(@RequestBody Notes note) {
        noteService.addNote(note);
    }
}
