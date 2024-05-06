package java13.service;

import java13.entiti.Course;

public interface CourseService {
    String createCourse(Course course);

    Course getCourseById(Long courseId);

    String updateCourse(Long courseId, Course newCourse);

    String deleteCourseById(Long courseId);
}
