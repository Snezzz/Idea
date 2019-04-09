package com.sweater;

import com.sweater.entities.Notes;
import com.sweater.enums.NoteType;
import com.sweater.enums.Priority;
import com.sweater.repositories.NotesRepository;
import com.sweater.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class GreetingController {


    @Autowired // This means to get the bean called userRepository
    private NotesRepository notesRepository;
    @Autowired // This means to get the bean called userRepository
    private TagRepository tagRepository;

    @GetMapping("/hello-world")
    //name - название параметра (для обращения из шаблона)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                   String name, Map<String, Object> model) {
        model.put("name", name);
        return "hello"; //имя файла для спрингового контейнера, который мы хотим отобразить
    }


    @GetMapping("/notes")
    //name - название параметра (для обращения из шаблона)
    public String getNotes(Map<String,Object> model) {

        notesRepository.save(new Notes(1,"firstNote",1,110,
                "здесь заметка",new java.util.Date(),NoteType.Note,Priority.FIVE));
        notesRepository.save(new Notes(2,"secondNote",1,10,
                "и тут заметка",new java.util.Date(),NoteType.Note,Priority.FOUR));
        Iterable<Notes> notes = notesRepository.findAll();
        model.put("notes",notes);
        return "notes";
    }


}
