package com.sweater.services;

import com.sweater.entities.Tag;
import com.sweater.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    //выводит все тэги
    public List<Tag> getTags(){
        return tagRepository.findAll();
    }

    //тэг по идентификатору
    public Tag getTagById(int id) {
        return tagRepository.findById(id).get();
    }

    //добавляет новый тэг
    public void addTag(Tag tag) {
        tagRepository.save(tag);
    }

    //удаляет тэг
    public void deleteTag(Tag tag) {
        tagRepository.delete(tag);
    }

    //удаляет тэг по идентификатору
    public void deleteTagById(int id) {
        tagRepository.deleteById(id);
    }

}

