package com.bluestaq.notes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bluestaq.notes.model.Note;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private int nextId = 1;

    public Note createNote(String title, String content) {
        String id = String.valueOf(nextId++);
        Note note = new Note(id, title, content);
        notes.add(note);
        return note;
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note getNoteById(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }

    public Note updateNote(String id, String title, String content) {
        Note note = getNoteById(id);
        if (note != null) {
            note.setTitle(title);
            note.setContent(content);
        }
        return note;
    }

    public boolean deleteNote(String id) {
        Note note = getNoteById(id);
        if (note != null) {
            notes.remove(note);
            return true;
        }
        return false;
    }
}
