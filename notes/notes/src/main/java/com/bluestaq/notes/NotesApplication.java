package com.bluestaq.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Notes application. This class is annotated with @SpringBootApplication, which enables auto-configuration, component scanning, and allows for defining extra configuration on the application class.
 */
@SpringBootApplication
public class NotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

}
