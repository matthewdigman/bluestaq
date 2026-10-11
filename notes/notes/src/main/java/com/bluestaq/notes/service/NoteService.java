/**
 * Project: Bluestaq Notes
 * File: service/NoteService.java
 * 
 * Description: This class represents the service layer for managing Note entities. It provides methods for creating, retrieving, updating, and deleting notes.
 * 
 * Author: Matthew Digman
 * Created: 2026-10-11
 */
package com.bluestaq.notes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bluestaq.notes.model.Note;

@Service
public class NoteService {
    /**
     * In-memory storage for Note entities. This list simulates a database for the purpose of this application.
     */
    private final List<Note> notes = new ArrayList<>();

    /**
     * Counter to generate unique IDs for new Note entities. This counter increments with each new note created.
     */
    private int nextId = 1;

    /**
     * Creates a new Note with the specified title and content. The method generates a unique ID for the note, adds it to the in-memory storage, and returns the created Note.
     * 
     * @param title The title of the new Note.
     * @param content The content of the new Note.
     * @return The newly created Note object.
     */
    public Note createNote(String title, String content) {
        String id = String.valueOf(nextId++);
        Note note = new Note(id, title, content);
        notes.add(note);
        return note;
    }

    /**
     * Retrieves all Note entities from the in-memory storage.
     * 
     * @return A list of all Note objects.
     */
    public List<Note> getAllNotes() {
        return notes;
    }

    /**
     * Retrieves a Note by its unique ID. If the note is found, it is returned; otherwise, null is returned.
     * 
     * @param id The unique identifier of the Note to retrieve.
     * @return The Note object with the specified ID, or null if not found.
     */
    public Note getNoteById(String id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }

    /**
     * Updates an existing Note with the specified ID, title, and content. If the note is found, its title and content are updated; otherwise, null is returned.
     * 
     * @param id The unique identifier of the Note to update.
     * @param title The new title for the Note.
     * @param content The new content for the Note.
     * @return The updated Note object, or null if the note was not found.
     */
    public Note updateNote(String id, String title, String content) {
        Note note = getNoteById(id);
        if (note != null) {
            note.setTitle(title);
            note.setContent(content);
        }
        return note;
    }

    /**
     * Deletes a Note by its unique ID. If the note is found and deleted, true is returned; otherwise, false is returned.
     * 
     * @param id The unique identifier of the Note to delete.
     * @return true if the note was found and deleted; false otherwise.
     */
    public boolean deleteNote(String id) {
        Note note = getNoteById(id);
        if (note != null) {
            notes.remove(note);
            return true;
        }
        return false;
    }
}
