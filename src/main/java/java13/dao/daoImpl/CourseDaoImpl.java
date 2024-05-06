package java13.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import java13.config.HibernateConfig;
import java13.dao.CourseDao;
import java13.entiti.Course;
import org.hibernate.HibernateException;


public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public String createCourse(Course course) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            return "Success";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public Course getCourseById(Long courseId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select c from Course c where c.id = :courseId").setParameter("courseId", courseId);
            Course getCourse = (Course) query.getSingleResult();
            return getCourse;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateCourse(Long courseId, Course newCourse) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update Course c set c.courseName =:courseName, c.description = :price where c.id =:courseId")
                    .setParameter("courseName", newCourse.getCourseName())
                    .setParameter("description", newCourse.getDescription())
                    .setParameter("courseId", newCourse.getId());
        }
        return null;
    }


    @Override
    public String deleteCourseById(Long courseId) {
        return null;
    }
}
