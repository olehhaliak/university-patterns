import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        courseImpl.getGroups().add(new Group(0,"group #0"));
        courseImpl.addStudent(student, new Enrollment());
        assertTrue(courseImpl.getGroups().get(0).getEnrolledStudents().containsKey(student));
    }

    @Test
    void removeStudent() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        courseImpl.addStudent(student, new Enrollment());
        courseImpl.removeStudent(student);
        assertFalse(courseImpl.getGroups().get(0).getEnrolledStudents().containsKey(student));
    }

    @Test
    void sendCourseMaterialsTest() {
        String materials = "materials";
        Group group = Mockito.mock(Group.class);
        courseImpl.sendCourseMaterials(group,materials);
        Mockito.verify(group).addCourseMaterial(courseImpl.name, materials);
        assertTrue(courseImpl.getGroups().contains(group));
    }

    @Test
    void getCourseMaterials() {
        String materials = "materials";
        Group group = Mockito.mock(Group.class);
        courseImpl.getGroups().add(group);
        Mockito.when(group.getCourseMaterials()).thenReturn(Collections.singletonMap(courseImpl.name, Collections.singletonList(materials)));
        assertTrue(courseImpl.getCourseMaterials(group).contains(materials));
    }

    @Test
    void getCourseMaterials_NonExistingGroup() {
        Group group = Mockito.mock(Group.class);
        assertTrue(courseImpl.getCourseMaterials(group).isEmpty());

    }

    @Test
    void addStudentToGroupTest() {
        Student student = Mockito.mock(Student.class);
        Enrollment enrollment = Mockito.mock(Enrollment.class);
        Group group = Mockito.mock(Group.class);
        Mockito.when(group.getEnrolledStudents()).thenReturn(Collections.singletonMap(student,enrollment));
        courseImpl.addStudentToGroup(student,enrollment,group);
        assertTrue(courseImpl.getGroups().get(0).getEnrolledStudents().containsKey(student));
        assertTrue(courseImpl.getGroups().get(0).getEnrolledStudents().containsValue(enrollment));
    }
}