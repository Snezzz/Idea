package com.sweater;

import com.sweater.entities.Notes;
import com.sweater.entities.User;
import com.sweater.enums.NoteType;
import com.sweater.enums.Priority;
import com.sweater.repositories.NotesRepository;
import com.sweater.repositories.TagRepository;
import com.sweater.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class GreetingController {

    

    @Autowired
    private UserRepository userService;
    
    @Autowired
    private NotesRepository notesService;
    @Autowired
    private TagRepository tagService;

    @GetMapping("/hello-world")
    //name - название параметра (для обращения из шаблона)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
                                   String name, Map<String, Object> model) {
        model.put("name", name);
        return "hello"; //имя файла для спрингового контейнера, который мы хотим отобразить
    }

   
   @GetMapping("/users")
    public String show(Map<String,Object> model) {
        userService.save(new User(1,"Ann","123"));
        userService.save(new User(2,"Bill","321"));
        userService.save(new User(3,"John","213"));
        Iterable<User> users = userService.findAll();
        model.put("users",users);
        return "test";
    }
   
 @GetMapping("/notes")
    public String getNotes(Map<String,Object> model) {

        notesService.save(new Notes(1,"firstNote",1,110,
                "здесь заметка",new java.util.Date(),NoteType.Note,Priority.FIVE));
        notesService.save(new Notes(2,"secondNote",1,10,
                "и тут заметка",new java.util.Date(),NoteType.Note,Priority.FOUR));
        Iterable<Notes> notes = notesService.findAll();
        model.put("notes",notes);
        return "notes";
    }
}






