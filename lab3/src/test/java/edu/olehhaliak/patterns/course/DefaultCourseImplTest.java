package edu.olehhaliak.patterns.course;

import edu.olehhaliak.patterns.Enrollment;
import edu.olehhaliak.patterns.Group;
import edu.olehhaliak.patterns.PersonalInfo;
import edu.olehhaliak.patterns.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DefaultCourseImplTest {
    DefaultCourseImpl defaultCourseImpl;

    @BeforeEach
    void setUp() {
        defaultCourseImpl = new DefaultCourseImpl("Applied math", LocalDate.now(),  8500);
    }

    @Test
    void addStudentTest() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        defaultCourseImpl.getGroups().add(new Group(0,"group #0"));
        defaultCourseImpl.addStudent(student, new Enrollment());
        assertTrue(defaultCourseImpl.getGroups().get(0).getEnrolledStudents().containsKey(student));
    }

    @Test
    void removeStudent() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        defaultCourseImpl.addStudent(student, new Enrollment());
        defaultCourseImpl.removeStudent(student);
        assertFalse(defaultCourseImpl.getGroups().get(0).getEnrolledStudents().containsKey(student));
    }

    @Test
    void sendCourseMaterialsTest() {
        String materials = "materials";
        Group group = Mockito.mock(Group.class);
        defaultCourseImpl.sendCourseMaterials(group,materials);
        Mockito.verify(group).addCourseMaterial(defaultCourseImpl.name, materials);
        assertTrue(defaultCourseImpl.getGroups().contains(group));
    }

    @Test
    void getCourseMaterials() {
        String materials = "materials";
        Group group = Mockito.mock(Group.class);
        defaultCourseImpl.getGroups().add(group);
        Mockito.when(group.getCourseMaterials()).thenReturn(Collections.singletonMap(defaultCourseImpl.name, Collections.singletonList(materials)));
        assertTrue(defaultCourseImpl.getCourseMaterials(group).contains(materials));
    }

    @Test
    void getCourseMaterials_NonExistingGroup() {
        Group group = Mockito.mock(Group.class);
        assertTrue(defaultCourseImpl.getCourseMaterials(group).isEmpty());

    }

    @Test
    void addStudentToGroupTest() {
        Student student = Mockito.mock(Student.class);
        Enrollment enrollment = Mockito.mock(Enrollment.class);
        Group group = Mockito.mock(Group.class);
        Mockito.when(group.getEnrolledStudents()).thenReturn(Collections.singletonMap(student,enrollment));
        defaultCourseImpl.addStudentToGroup(student,enrollment,group);
        assertTrue(defaultCourseImpl.getGroups().get(0).getEnrolledStudents().containsKey(student));
        assertTrue(defaultCourseImpl.getGroups().get(0).getEnrolledStudents().containsValue(enrollment));
    }
}