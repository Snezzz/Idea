package com.sweater.services;

import com.sweater.entities.Notes;
import com.sweater.repositories.NotesRepository;
import com.sweater.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NotesRepository noteRepository;

    @Autowired
    public NoteService(NotesRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Notes> getAllNotes() {
        List<Notes> list = new ArrayList<>();
        noteRepository.findAll().forEach(e -> list.add(e));
        return list;
    }


    public Notes getNoteById(int Id) {
        Optional<Notes> note = noteRepository.findById(Id);
        return note.orElseThrow(NotFoundException::new);
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
