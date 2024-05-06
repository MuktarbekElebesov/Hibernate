package java13.entiti;

import jakarta.persistence.*;
import java13.dao.daoImpl.StudentDaoImpl;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true)
    private String courseName;
    private String description;
    @ManyToMany
    private List<Students> students;

    public Course(String courseName, String description, List<Students> students) {
        this.courseName = courseName;
        this.description = description;
        this.students = students;
    }
}
