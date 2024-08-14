package com.thecosmickay.backend_notula.services;

import com.thecosmickay.backend_notula.model.Note;

import java.util.List;

public interface NotesServices {
    Note createNote(Note note);

    List<Note> getAllNotes();

    Note deleteNote(long noteID);

    Note getNoteByID(long noteID);

    Note updateNote(long noteID, Note note);
}
