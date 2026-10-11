# bluestaq
Assessment

Task:
You're building the backend for a note-taking service used and shared amongst several small teams.  Users need somewhere to capture and work with their notes.

Deliver a runnable REST service and README.

Design Decisions:
2-3 design choices you spent the most time on, and why you made them
 * This is a pretty barebones service.  I wanted to use Spring as my base framework since it allows for fast creation of RESTful services and annotation.  Next I seperated architecture into the three basic layers (Controller/Service/Model) for cleaner code.  The service itself allows for the creation of a note object with a title and content.  The ID is assigned based on a running counter as new notes are created.  You are able to get all the notes or a specific note based on ID.  You can then update or delete notes using that ID. I utilized an ArrayList with the intent of using PostgreSQL but ran out of time.  It is atleast thread-safe and won't interfere with the multiple teams interacting with it. I included the test commands I used below for interacting with the service.
 *
What you'd change, add, or stop doing if you had more time
 * The first thing I would add is a database to store all the notes because they disappear when you shut down the service.  They are currently stored in an ArrayList and would be better suited in PostgreSQL which I believe Spring has an API for.  Using Hibernate would also allow for interacting with the database easier utilizing object mapping.  I think I spent a good amount of the test time setting up my laptop for coding so that really cut into the time I needed to keep going.
 * I would also generate an API for the other teams to use for simplicity of figuring out how to use the service without having to open my source files.  I've previously used Swagger that can generate a web page with the endpoints and documentation on how to use them.
 * There also needs to be some form of validation to make sure users are inputs valid titles/content for notes to prevent bad data and malformed requests.  Adding in some form of error handling would also help the teams to figure out if something went wrong with their notes
 * Finally add in some security features since there are multiple teams accessing the service.  Some users may only need read access while power users would need full CRUD capabilities.  Right now every is essentially an admin with full access to everything.
 * In addition to updating features, creating a full testing suite of unit/API tests and eventually utilizing some automated testing platforms like ReadyAPI 


Testing the Note Service:

===========================================================

JSON Note:
{
    "title":"NoteTitle",
    "content":"NoteContent"
}

===========================

Note Commands:

createNote:
curl.exe -X POST http://localhost:8080/api/notes -H "Content-Type: application/json" -d '{\"title\":\"TestNote\",\"content\":\"Test!\"}'

getAllNotes:
curl.exe -X GET http://localhost:8080/api/notes

getNoteById: (id = 1)
curl.exe -X POST http://localhost:8080/api/notes/1

updateNote:
curl.exe -X GET http://localhost:8080/api/notes -H "Content-Type: application/json" -d '{\"id\":\"1\",\"title\":\"TestNote\",\"content\":\"Updated!\"}'

deleteNote: (id = 1)
curl.exe -X DELETE http://localhost:8080/api/notes/1

===========================================================
