import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentTest {
    @Mock
    Course course;
    Student student;

    @BeforeEach
    void setUp() {
        student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
    }

    @Test
    void canEnrollTest() {
        assertTrue(student.canEnroll(course));
    }

    @Test
    void enrollTest() {
        student.enroll(course);
        assertTrue(student.getEnrollments().containsKey(course));
        verify(course).addStudent(student, student.getEnrollments().get(course));
    }

    @Test
    void unenrollTest() {
        student.enroll(course);
        student.unenroll(course);
        assertFalse(student.getEnrollments().containsKey(course));
        verify(course).removeStudent(student);
    }

    @Test
    void calculateWorkloadTest() {
        assertEquals(1., student.calculateWorkload());
    }

    @Test
    void addViolationTest() {
        student.addViolation("Cheated on exams!");
        student.addViolation("Broke a window!");
        System.out.println(student.getViolations());
    }

    @Test
    void visitSeminarTest() {
        Course course = new Course("math", LocalDate.now(), 5, 0);
        student.enroll(course);
        Enrollment e = student.getEnrollments().get(course);
        assertEquals(0, e.getVisitedSeminars().size());
        Seminar seminar = new Seminar();
        seminar.setRelatedCourse("math");
        student.visitSeminar(seminar);
        assertEquals(1, e.getVisitedSeminars().size());
    }
}