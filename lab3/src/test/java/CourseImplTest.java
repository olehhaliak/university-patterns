import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseImplTest {
    CourseImpl courseImpl;

    @BeforeEach
    void setUp() {
        courseImpl = new CourseImpl("Applied math", LocalDate.now(),  8500);
    }

    @Test
    void addStudentTest() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        courseImpl.addStudent(student, new Enrollment());
        assertTrue(courseImpl.getEnrolledStudents().containsKey(student));
    }

    @Test
    void removeStudent() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        courseImpl.addStudent(student, new Enrollment());
        courseImpl.removeStudent(student);
        assertFalse(courseImpl.getEnrolledStudents().containsKey(student));
    }
}