/**
 * Project: Bluestaq Notes
 * File: controller/NoteController.java
 * 
 * Description: This class serves as the REST controller for managing Note entities. It provides endpoints for creating, retrieving, updating, and deleting notes. The controller interacts with the NoteService to perform the necessary operations on the Note model.
 * 
 * Author: Matthew Digman
 * Created: 2026-10-11
 */
package com.bluestaq.notes.controller;

import java.util.List;
import com.bluestaq.notes.model.Note;
import com.bluestaq.notes.service.NoteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    /**
     * The NoteService instance used to perform operations on Note entities. This service is injected into the controller to handle the business logic related to notes.
     */
    private final NoteService noteService;

    /**
     * Constructor for NoteController. Initializes the controller with the provided NoteService instance.
     * 
     * @param noteService The NoteService instance to be used by this controller.
     */
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    /**
     * Retrieves all Note entities. This endpoint responds to GET requests at the base URL and returns a list of all notes.
     * 
     * @return A list of all Note objects.
     */
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    /**
     * Creates a new Note entity. This endpoint responds to POST requests at the base URL and expects a Note object in the request body. The created note is returned in the response.
     * 
     * @param note The Note object to be created, provided in the request body.
     * @return The newly created Note object.
     */
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note.getTitle(), note.getContent());
    }

    /**
     * Retrieves a Note entity by its unique ID. This endpoint responds to GET requests at the URL with the specified ID and returns the corresponding note if found.
     * 
     * @param id The unique identifier of the Note to retrieve, provided as a path variable.
     * @return The Note object with the specified ID, or null if not found.
     */
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable String id) {
        return noteService.getNoteById(id);
    }

    /**
     * Updates an existing Note entity. This endpoint responds to PUT requests at the URL with the specified ID and expects a Note object in the request body. The updated note is returned in the response.
     * 
     * @param id The unique identifier of the Note to update, provided as a path variable.
     * @param note The Note object containing the updated title and content, provided in the request body.
     * @return The updated Note object, or null if the note was not found.
     */
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable String id, @RequestBody Note note) {
        return noteService.updateNote(id, note.getTitle(), note.getContent());
    }

    /**
     * Deletes a Note entity by its unique ID. This endpoint responds to DELETE requests at the URL with the specified ID and returns a boolean indicating whether the deletion was successful.
     * 
     * @param id The unique identifier of the Note to delete, provided as a path variable.
     * @return true if the note was found and deleted; false otherwise.
     */
    @DeleteMapping("/{id}")
    public boolean deleteNote(@PathVariable String id) {
        return noteService.deleteNote(id);
    }
}
