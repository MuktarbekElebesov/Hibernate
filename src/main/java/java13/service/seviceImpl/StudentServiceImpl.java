package java13.service.seviceImpl;

import java13.dao.StudentDao;
import java13.dao.daoImpl.StudentDaoImpl;
import java13.entiti.Students;
import java13.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public String createStudent(Students students) {
        return studentDao.createStudent(students);
    }

    @Override
    public Students getStudentById(Long studentId) {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public Students updateStudent(Long studentId, Students newStudents) {
        return studentDao.updateStudent(studentId, newStudents);
    }

    @Override
    public String deleteStudentById(Long studentId) {
        return studentDao.deleteStudentById(studentId);
    }
}
