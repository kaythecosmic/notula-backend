package com.thecosmickay.backend_notula.controller;


import com.thecosmickay.backend_notula.model.Note;
import com.thecosmickay.backend_notula.response.ApiResponse;
import com.thecosmickay.backend_notula.services.NotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class NotesController {

    private final NotesServices notesServices;

    public NotesController(NotesServices notesServices) {
        this.notesServices = notesServices;
    }

    @PostMapping("/notes")
    public Note createNewNote(@RequestBody Note newNote) {
        return notesServices.createNote(newNote);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return notesServices.getAllNotes();
    }

    @DeleteMapping("/delNote/{noteID}")
    public ResponseEntity<ApiResponse<Note>> deleteNote(@PathVariable("noteID") long noteID) {

        boolean isDeleted = false;
        Note deletedNote = notesServices.deleteNote(noteID);
        ApiResponse<Note> response = new ApiResponse<Note>(false, "", null);
        String message;
        if (deletedNote != null) {
            response.setMessage("Note deleted successfully");
            response.setData(deletedNote);
            response.setSuccess(true);
            return ResponseEntity.ok().body(response);
        }
        response.setMessage("Failed to delete Note.");
        return ResponseEntity.badRequest().body(response);
    }
}
