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

    //выводит все тэги
    @GetMapping("/tags")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    //выводит тэг по идентификатору
    @GetMapping("/tagById")
    public Tag getTagById(@RequestBody int id) {
        return tagService.getTagById(id);
    }

    //добавляет новый тэг
    @PostMapping("/tag")
    public void addTag(@RequestBody Tag tag) {
        tagService.addTag(tag);
    }

    //удаляет тэг
    @DeleteMapping("/tag")
    public void deleteTag(@RequestBody Tag tag) {
        tagService.deleteTag(tag);
    }

    //удаляет тэг по идентификатору
    @DeleteMapping("/tagById")
    public void deleteTagById(@RequestBody int id) {
        tagService.deleteTagById(id);
    }

}

