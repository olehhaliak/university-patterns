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
    CourseImpl courseImpl;
    Student student;

    @BeforeEach
    void setUp() {
        student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
    }

    @Test
    void canEnrollTest() {
        assertTrue(student.canEnroll(courseImpl));
    }

    @Test
    void enrollTest() {
        student.enroll(courseImpl);
        assertTrue(student.getEnrollments().containsKey(courseImpl));
        verify(courseImpl).addStudent(student, student.getEnrollments().get(courseImpl));
    }

    @Test
    void unenrollTest() {
        student.enroll(courseImpl);
        student.unenroll(courseImpl);
        assertFalse(student.getEnrollments().containsKey(courseImpl));
        verify(courseImpl).removeStudent(student);
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
        CourseImpl courseImpl = new CourseImpl("math", LocalDate.now(), 0);
        student.enroll(courseImpl);
        Enrollment e = student.getEnrollments().get(courseImpl);
        assertEquals(0, e.getVisitedSeminars().size());
        Seminar seminar = new Seminar();
        seminar.setRelatedCourse("math");
        student.visitSeminar(seminar);
        assertEquals(1, e.getVisitedSeminars().size());
    }
}