package edu.olehhaliak.patterns.administration;

import edu.olehhaliak.patterns.Group;
import edu.olehhaliak.patterns.Professor;
import edu.olehhaliak.patterns.course.Course;
import edu.olehhaliak.patterns.course.DesignPatterns;
import edu.olehhaliak.patterns.course.MachineLearning;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class HeadDepartmentTest {
    @Test
    void attachCourseTest() {
        Group group = Mockito.mock(Group.class);
        Professor professor = Mockito.mock(Professor.class);
        HeadDepartment headDepartment = new HeadDepartment(null);
        headDepartment.fillCourse(professor,group);

        Course course1 = headDepartment.getCourses().get(0);
        assertTrue(course1 instanceof DesignPatterns||course1 instanceof MachineLearning);
        assertEquals(group,course1.getGroups().get(0));
        assertEquals(professor,course1.getProfessor());

        Course course2 = headDepartment.getCourses().get(1);
        assertTrue(course2 instanceof DesignPatterns||course2 instanceof MachineLearning);
        assertEquals(group,course2.getGroups().get(0));
        assertEquals(professor,course2.getProfessor());
    }
}