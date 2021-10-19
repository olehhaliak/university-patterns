import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course course;

    @BeforeEach
    void setUp() {
        course = new Course("Applied math", LocalDate.now(), 5, 8500);
    }

    @Test
    void addStudentTest() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        course.addStudent(student, new Enrollment());
        assertTrue(course.getEnrolledStudents().containsKey(student));
    }

    @Test
    void removeStudent() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        course.addStudent(student, new Enrollment());
        course.removeStudent(student);
        assertFalse(course.getEnrolledStudents().containsKey(student));
    }
}