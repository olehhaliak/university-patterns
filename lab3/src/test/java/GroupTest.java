import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    Group group;
    @BeforeEach
    void setUp() {
        group = new Group(1,"Fep-22");
    }
    @Test
    void addStudentTest() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        group.addStudent(student, new Enrollment());
        assertTrue(group.getEnrolledStudents().containsKey(student));
    }

    @Test
    void removeStudent() {
        Student student = new Student(new PersonalInfo(1, "John", "Lviv", "0992121244", "joht@g.com"), 1);
        group.addStudent(student, new Enrollment());
        group.removeStudent(student);
        assertFalse(group.getEnrolledStudents().containsKey(student));
    }

    @Test
    void addCourseMaterial() {
        String material ="https://math.com/help";
        group.addCourseMaterial("math",material);
        assertEquals(material,group.getCourseMaterials().get("math").get(0));
    }
}