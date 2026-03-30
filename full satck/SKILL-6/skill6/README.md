# SkillExperiment6 - Spring Boot REST Controller

## Aim
To build a Spring Boot REST controller for a Library system with multiple endpoints using @GetMapping, @PostMapping, @PathVariable, and @RequestParam.

## Tech Used
- Java 17
- Spring Boot 4.0.2
- Maven

## How to Run

Import as Maven project in Eclipse/STS, then run `SkillExperiment6Application.java` as Spring Boot App.

Server starts at: http://localhost:8020

## Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /welcome | Returns welcome message |
| GET | /count | Returns total book count |
| GET | /price | Returns sample book price |
| GET | /books | Returns list of book titles |
| GET | /books/{id} | Returns details for a book by ID |
| GET | /search?title= | Search book by title param |
| GET | /author/{name} | Returns author name |
| POST | /addbook | Adds a Book object to in-memory list |

## Project Structure

```
src/main/java/com/example/SkillExperiment6/
    SkillExperiment6Application.java
    LibraryController.java
    Book.java
src/main/resources/
    application.properties
```
