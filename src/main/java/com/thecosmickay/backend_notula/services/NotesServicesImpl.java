package com.thecosmickay.backend_notula.services;

import com.thecosmickay.backend_notula.entity.NotesEntity;
import com.thecosmickay.backend_notula.model.Note;
import com.thecosmickay.backend_notula.repository.NotesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotesServicesImpl implements NotesServices {

    private final NotesRepository notesRepository;

    public NotesServicesImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public Note createNote(Note note) {
        NotesEntity notesEntity = new NotesEntity();
        BeanUtils.copyProperties(note, notesEntity);
        notesEntity.setDate(LocalDateTime.now());
        notesRepository.save(notesEntity);
        BeanUtils.copyProperties(notesEntity, note);
        return note;
    }

    @Override
    public List<Note> getAllNotes() {
        List<NotesEntity> notesEntities
                = notesRepository.findAll();

        List<Note> notes;
        notes = notesEntities
                .stream()
                .map(note -> new Note(
                        note.getId(),
                        note.getTitle(),
                        note.getContent(),
                        note.getDate(),
                        note.getColor(),
                        note.getPosition(),
                        note.getTags()
                ))
                .collect(Collectors.toList());
        return notes;
    }

    @Override
    public Note deleteNote(long noteID) {
        Optional<NotesEntity> targetNote = notesRepository.findById(noteID);
        if (targetNote.isPresent()) {
            Note responseNote = new Note();
            BeanUtils.copyProperties(targetNote.get(), responseNote);
            notesRepository.delete(targetNote.get());
            return responseNote;
        }
        return null;
    }

    @Override
    public Note getNoteByID(long noteID) {
        Optional<NotesEntity> targetNote = notesRepository.findById(noteID);
        if (targetNote.isPresent()) {
            Note responseFetchedNote = new Note();
            BeanUtils.copyProperties(targetNote.get(), responseFetchedNote);
            return responseFetchedNote;
        }
        return null;
    }

    @Override
    public Note updateNote(long noteID, Note note) {
        Optional<NotesEntity> targetNote = notesRepository.findById(noteID);
        if (targetNote.isPresent()) {
            Note responseNoteUpdated = new Note();
            NotesEntity dockingTargetNote = targetNote.get();
            dockingTargetNote.setTitle(note.getTitle());
            dockingTargetNote.setContent(note.getContent());
            dockingTargetNote.setColor(note.getColor());
            dockingTargetNote.setPosition(note.positionObject());
            dockingTargetNote.setTags(note.getTags());
            notesRepository.save(dockingTargetNote);
            BeanUtils.copyProperties(dockingTargetNote, responseNoteUpdated);
            return responseNoteUpdated;
        }
        return null;

    }
}
