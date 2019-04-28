package com.sweater.entities;


import com.sweater.enums.NoteType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "notes_table")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int userId;
  
    @ManyToMany
    private Set<Tag> tags;
    @Column(length = 1000)
    private String text;
    private Date creationDate;
    private NoteType type;
    private Integer priority;
    //getters and setters

   public Notes() {

    }

   public Notes(int id, String title, int userId, Set<Tag> tags, String text, Date date, NoteType type,Integer priority) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.tags = tags;
        this.text = text;
        this.creationDate = date;
        this.type = type;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public NoteType getType() {
        return type;
    }

    public void setType(NoteType type) {
        this.type = type;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
