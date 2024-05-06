package java13.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java13.config.HibernateConfig;
import java13.dao.StudentDao;
import java13.entiti.Course;
import java13.entiti.Students;
import org.hibernate.HibernateException;


public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public String createStudent(Students students) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(students);
            entityManager.getTransaction().commit();
            return "Success";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public Students getStudentById(Long studentId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select s from Students s where s.id = :studentId").setParameter("studentId", studentId);
            Course getCourse = (Course) query;
            return (Students) getCourse.getStudents();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Students updateStudent(Long studentId, Students newStudents) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update Students s set s.fullName =:fullName, s.email = :email where s.id =:studentId")
                    .setParameter("fullName", newStudents.getFullName())
                    .setParameter("email", newStudents.getEmail())
                    .setParameter("studentId", newStudents.getId());
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteStudentById(Long studentId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Students students = entityManager.find(Students.class, studentId);
            entityManager.remove(students);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "ok";
        }
    }
}
