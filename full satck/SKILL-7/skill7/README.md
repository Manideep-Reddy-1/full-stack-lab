# Experiment 8 - Course REST API using ResponseEntity

## Aim
Build a Spring Boot REST API for Course management using `ResponseEntity` for proper HTTP status code handling.

## Technologies
- Java 17
- Spring Boot 3.2.x
- Spring Data JPA
- MySQL 8
- Maven

## REST Endpoints

| Method | URL | Description | Success Status |
|--------|-----|-------------|---------------|
| POST | /courses | Create a new course | 201 CREATED |
| GET | /courses | Get all courses | 200 OK |
| GET | /courses/{id} | Get course by ID | 200 OK |
| PUT | /courses/{id} | Update course | 200 OK |
| DELETE | /courses/{id} | Delete course | 200 OK |
| GET | /courses/search/{title} | Search by title | 200 OK |

## Setup
1. Create MySQL database: `CREATE DATABASE coursedb;`
2. Update `src/main/resources/application.properties` with your DB password
3. Run `REApplication.java` as Spring Boot App

## Sample Request Body (POST /courses)
```json
{
  "courseId": 1,
  "title": "Spring Boot",
  "duration": "3 months",
  "fee": 5000
}
```

## Project Structure
```
src/main/java/com/example/RE/
├── REApplication.java      (Main Spring Boot entry point)
├── Course.java             (@Entity)
├── CourseRepository.java   (JpaRepository)
├── CourseService.java      (@Service)
└── CourseController.java   (@RestController with ResponseEntity)
src/main/resources/
└── application.properties
pom.xml
```
