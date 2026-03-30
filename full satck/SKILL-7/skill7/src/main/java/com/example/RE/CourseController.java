package com.example.RE;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // POST /courses - Create a new course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        service.addCourse(course);
        return new ResponseEntity<>("Course Created Successfully", HttpStatus.CREATED);
    }

    // GET /courses - Get all courses
    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        List<Course> list = service.getAllCourses();
        if (list.isEmpty())
            return new ResponseEntity<>("No Courses Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // GET /courses/{id} - Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Course c = service.getCourseById(id);
        if (c == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // PUT /courses/{id} - Update course
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,
                                           @RequestBody Course course) {
        Course updated = service.updateCourse(id, course);
        if (updated == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Course Updated", HttpStatus.OK);
    }

    // DELETE /courses/{id} - Delete course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        Course c = service.getCourseById(id);
        if (c == null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        service.deleteCourse(id);
        return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
    }

    // GET /courses/search/{title} - Search by title
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourses(@PathVariable String title) {
        List<Course> list = service.searchByTitle(title);
        if (list.isEmpty())
            return new ResponseEntity<>("No Matching Courses", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
