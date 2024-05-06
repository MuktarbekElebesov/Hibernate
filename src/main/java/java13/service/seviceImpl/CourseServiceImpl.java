package java13.service.seviceImpl;

import java13.dao.CourseDao;
import java13.dao.daoImpl.CourseDaoImpl;
import java13.entiti.Course;
import java13.service.CourseService;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public String createCourse(Course course) {
        return courseDao.createCourse(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        return courseDao.updateCourse(courseId, newCourse);
    }

    @Override
    public String deleteCourseById(Long courseId) {
        return courseDao.deleteCourseById(courseId);
    }
}
