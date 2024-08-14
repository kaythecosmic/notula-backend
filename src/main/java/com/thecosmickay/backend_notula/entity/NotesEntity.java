package com.thecosmickay.backend_notula.entity;


import com.thecosmickay.backend_notula.model.Color;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name = "notes")
public class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private Color color;
    private List<String> tags;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Color getColor() {
        return color;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
