package java13.dao;

import java13.entiti.Students;

import java.util.List;

public interface StudentDao {
    String  createStudent(Students students);
    Students getStudentById (Long studentId);
    Students updateStudent(Long studentId, Students newStudents);
    String  deleteStudentById (Long studentId);

}
