package edu.olehhaliak.patterns.administration;

import edu.olehhaliak.patterns.Group;
import edu.olehhaliak.patterns.Professor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DeanTest {
    @Test
    void attachCourseTest() {
        Group group = Mockito.mock(Group.class);
        Professor professor = Mockito.mock(Professor.class);
        Dean dean = new Dean(null);
        dean.fillCourse(professor,group);
        assertEquals(professor,dean.attachCourse().get(0).getProfessor());
        assertEquals(group,dean.attachCourse().get(0).getGroups().get(0));
    }
}