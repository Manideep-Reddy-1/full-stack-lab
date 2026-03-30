package com.example.RE;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(int id) {
        Optional<Course> c = repo.findById(id);
        return c.orElse(null);
    }

    public Course updateCourse(int id, Course course) {
        if (repo.existsById(id)) {
            course.setCourseId(id);
            return repo.save(course);
        }
        return null;
    }

    public void deleteCourse(int id) {
        repo.deleteById(id);
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContaining(title);
    }
}
