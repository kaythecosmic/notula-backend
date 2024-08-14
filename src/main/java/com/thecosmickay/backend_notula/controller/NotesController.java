package com.thecosmickay.backend_notula.controller;


import com.thecosmickay.backend_notula.model.Note;
import com.thecosmickay.backend_notula.response.ApiResponse;
import com.thecosmickay.backend_notula.services.NotesServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Note deletedNote = notesServices.deleteNote(noteID);
        ApiResponse<Note> response = new ApiResponse<Note>(false, "Failed to delete Note.", null);
        if (deletedNote != null) {
            response.setMessage("Note deleted successfully");
            response.setData(deletedNote);
            response.setSuccess(true);
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("/notes/{noteID}")
    public ResponseEntity<ApiResponse<Note>> getNoteByID(@PathVariable("noteID") long noteID) {
        Note fetchedNote = notesServices.getNoteByID(noteID);
        ApiResponse<Note> response = new ApiResponse<Note>(false, "Desired Note Unavailable.", null);
        if (fetchedNote != null) {
            response.setMessage("Desired note found successfully.");
            response.setData(fetchedNote);
            response.setSuccess(true);
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/notes/{noteID}")
    public ResponseEntity<ApiResponse<Note>> updateEmployee(@PathVariable("noteID") long noteID, @RequestBody Note note) {
        Note updatedNote = notesServices.updateNote(noteID, note);
        ApiResponse<Note> response = new ApiResponse<Note>(false, "Failed to update note.", null);
        if (updatedNote != null) {
            response.setSuccess(true);
            response.setMessage("Updated Note successfully.");
            response.setData(updatedNote);
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
