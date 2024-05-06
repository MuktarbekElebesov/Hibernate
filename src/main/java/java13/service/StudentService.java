package java13.service;

import java13.entiti.Students;

import java.util.List;

public interface StudentService {
    String  createStudent(Students students);
    Students getStudentById (Long studentId);
    Students updateStudent(Long studentId, Students newStudents);
    String  deleteStudentById (Long studentId);
}
