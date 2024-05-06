package java13.dao;

import java13.entiti.Course;
import java13.entiti.Students;

import java.util.List;

public interface CourseDao {
    String createCourse(Course course);

    Course getCourseById(Long courseId);

    String updateCourse(Long courseId, Course newCourse);

    String deleteCourseById(Long courseId);

}
