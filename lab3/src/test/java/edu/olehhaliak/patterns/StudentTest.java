package edu.olehhaliak.patterns;

import edu.olehhaliak.patterns.course.DefaultCourseImpl;
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
    DefaultCourseImpl defaultCourseImpl;
    Student student;

    @BeforeEach
    void setUp() {
        student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
    }

    @Test
    void canEnrollTest() {
        assertTrue(student.canEnroll(defaultCourseImpl));
    }

    @Test
    void enrollTest() {
        student.enroll(defaultCourseImpl);
        assertTrue(student.getEnrollments().containsKey(defaultCourseImpl));
        verify(defaultCourseImpl).addStudent(student, student.getEnrollments().get(defaultCourseImpl));
    }

    @Test
    void unenrollTest() {
        student.enroll(defaultCourseImpl);
        student.unenroll(defaultCourseImpl);
        assertFalse(student.getEnrollments().containsKey(defaultCourseImpl));
        verify(defaultCourseImpl).removeStudent(student);
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
        DefaultCourseImpl defaultCourseImpl = new DefaultCourseImpl("math", LocalDate.now(), 0);
        student.enroll(defaultCourseImpl);
        Enrollment e = student.getEnrollments().get(defaultCourseImpl);
        assertEquals(0, e.getVisitedSeminars().size());
        Seminar seminar = new Seminar();
        seminar.setRelatedCourse("math");
        student.visitSeminar(seminar);
        assertEquals(1, e.getVisitedSeminars().size());
    }
}