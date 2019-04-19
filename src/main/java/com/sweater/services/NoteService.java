package com.sweater.services;

import com.sweater.entities.Notes;
import com.sweater.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NotesRepository noteRepository;

    @Autowired
    public NoteService(NotesRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Notes> getAllNotes() {
      return noteRepository.findAll();
    }


    public Notes getNoteById(int Id) {
        return noteRepository.findById(Id).get();
    }

    public void updateNote(Notes note) {
        noteRepository.save(note);
    }

    public void deleteNote(int Id) {
        noteRepository.delete(getNoteById(Id));
    }

    public void addNote(Notes note) {
        noteRepository.save(note);
    }

}
