import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentTest {
    Enrollment enrollment;

    @BeforeEach
    void setUp() {
        enrollment = new Enrollment();
    }

    @Test
    public void getFinalMarkTest() {
        enrollment.addMark(50);
        enrollment.addMark(60);
        enrollment.addMark(70);
        float expectedFinalMark = 60;
        assertEquals(expectedFinalMark, enrollment.getFinalMark());
    }

    @Test
    public void getAverageMarkToDateTest() {
        enrollment.addMark(LocalDate.of(2020, 2, 24), 50);
        enrollment.addMark(LocalDate.of(2020, 5, 29), 70);
        enrollment.addMark(LocalDate.of(2021, 2, 24), 90);
        float expectedAverageMarkToDate = 60;
        assertEquals(expectedAverageMarkToDate, enrollment.getAverageMarkToDate(LocalDate.of(2020, 5, 29)));
    }

    @Test
    void getSeminarsToDateTest() {
        Seminar seminar1 = new Seminar();
        seminar1.setId(1);
        Seminar seminar2 = new Seminar();
        seminar2.setId(2);
        Seminar seminar3 = new Seminar();
        seminar3.setId(3);
        Enrollment enrollment = new Enrollment();
        enrollment.addAttendanceRecord(seminar1, LocalDate.of(2020, 10, 10));
        enrollment.addAttendanceRecord(seminar2, LocalDate.of(2020, 10, 12));
        enrollment.addAttendanceRecord(seminar3, LocalDate.of(2020, 10, 15));
        assertEquals(1, enrollment.getSeminarsToDate(LocalDate.of(2020, 10, 10)).size());
    }
}