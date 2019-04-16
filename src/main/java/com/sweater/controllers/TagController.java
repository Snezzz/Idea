package com.sweater.controllers;

import com.sweater.entities.Tag;
import com.sweater.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    //выводит все тэги
    @GetMapping("/tags")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    //выводит тэг по идентификатору
    @GetMapping("/tag/{id}")
    public Tag getTagById(@PathVariable int id) {
        return tagService.getTagById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    //добавляет новый тэг
    @PostMapping("/tag")
    public void addTag(@RequestBody Tag tag) {
        tagService.addTag(tag);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    //удаляет тэг
    @DeleteMapping("/tag")
    public void deleteTag(@RequestBody Tag tag) {
        tagService.deleteTag(tag);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    //удаляет тэг по идентификатору
    @DeleteMapping("/tag/{id}")
    public void deleteTagById(@PathVariable int id) {
        tagService.deleteTagById(id);
    }

}

