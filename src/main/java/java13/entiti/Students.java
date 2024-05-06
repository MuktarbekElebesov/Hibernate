package java13.entiti;

import jakarta.persistence.*;
import java13.entiti.Course;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String enrollmentDate;
    @ManyToMany
    private List<Course> course;

    public Students(String fullName, String email, String enrollmentDate, List<Course> course) {
        this.fullName = fullName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.course = course;
    }
}
