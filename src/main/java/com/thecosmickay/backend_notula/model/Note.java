package com.thecosmickay.backend_notula.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Note {
    private long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private Color color;
    private List<String> tags;

    public Note(long id, String title, String content, LocalDateTime date, Color color, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.color = color;
        this.tags = tags;
    }

    public Note() {

    }
}
