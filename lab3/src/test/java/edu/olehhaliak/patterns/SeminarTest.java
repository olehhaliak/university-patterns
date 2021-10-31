package edu.olehhaliak.patterns;

import edu.olehhaliak.patterns.PersonalInfo;
import edu.olehhaliak.patterns.Professor;
import edu.olehhaliak.patterns.Seminar;
import edu.olehhaliak.patterns.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeminarTest {
    Seminar seminar;

    @BeforeEach
    void setUp() {
        seminar = new Seminar();
    }

    @Test
    void addCommentTest() {
        Staff staff = new Professor(new PersonalInfo(1, "Andriy", "Lviv", "nAn", "a@g.com"), 8000);
        String comment = "Hello there";
        seminar.addComment(staff, comment);
        String resultingComment = staff.getPersonalInfo().getName() + " : " + comment + "\n";
        assertEquals(resultingComment, seminar.getComments());
    }

    @Test
    void implementItemTest() {
        String item = "item";
        assertEquals(item,seminar.implementItem(item));
    }
}