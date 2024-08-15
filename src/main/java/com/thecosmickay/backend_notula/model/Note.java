package com.thecosmickay.backend_notula.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Note {
    private long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private Color color;
    private NotePosition position;
    private List<String> tags;

    public Note(long id, String title, String content, LocalDateTime date, Color color, NotePosition position, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.color = color;
        this.position = position;
        this.tags = tags;
    }

    public Note() {
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public NotePosition positionObject() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new NotePosition(x, y);
    }

    public void setPosition(NotePosition position) {
        this.position = position;
    }
}
