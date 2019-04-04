package com.sweater.entities;


import com.sweater.enums.NoteType;
import com.sweater.enums.Priority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Notes")
public class Notes {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private int userId;
    private int tags;
    private String text;
    private Date creationDate;
    private NoteType type;
    private Priority priority;
    //getters and setters

   public Notes() {

    }

   public Notes(int id, String title, int userId, int tags, String text, Date date, NoteType type,Priority priority) {
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

    public int getTags() {
        return tags;
    }

    public void setTags(int tags) {
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
