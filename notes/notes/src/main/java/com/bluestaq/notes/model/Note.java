/**
 * Project: Bluestaq Notes
 * File: model/Note.java
 * 
 * Description: This class represents a Note entity with an id, title, and content.
 * It provides constructors, getters, and setters for the Note properties.
 * 
 * Author: Matthew Digman
 * Created: 2026-10-11
 */
package com.bluestaq.notes.model;

public class Note {
    private String id;
    private String title;
    private String content;

    /**
     * Default constructor for Note. Initializes id, title, and content to empty strings.
     * This constructor is useful for frameworks that require a no-argument constructor.
     */
    public Note() {
        this.id = "";
        this.title = "";
        this.content = "";
    }

    /**
     * Parameterized constructor for Note. Initializes the Note with the provided id, title, and content.
     * 
     * @param id The unique identifier for the Note.
     * @param title The title of the Note.
     * @param content The content of the Note.
     */
    public Note(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    /**
     * Getter for the id property of the Note.
     * 
     * @return The id of the Note.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for the id property of the Note.
     * 
     * @param id The new id to set for the Note.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the title property of the Note.
     * 
     * @return The title of the Note.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the title property of the Note.
     * 
     * @param title The new title to set for the Note.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the content property of the Note.
     * 
     * @return The content of the Note.
     */
    public String getContent() {
        return content;
    }

    /**
     * Setter for the content property of the Note.
     * 
     * @param content The new content to set for the Note.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
