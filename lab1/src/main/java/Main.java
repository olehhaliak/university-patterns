import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Date;

@Slf4j
public class Main {
    public static void main(String[] args) {

        log.warn("Creating classes...");
        Student student = new Student("Andrew", "Lviv,Sikorskoho 44", "+0954323111", "andy@g.com", 1, 84);
        Professor professor = new Professor("George", "Drohobych, Sambirska st., 44/15", "+380962121112", "georgy@g.com", 9500);
        Course course = new Course("applied math", new Date(System.currentTimeMillis()),professor, 15, 8500);
        log.warn("Enrolling student into a course...");
        student.enroll(course);
        log.warn("Student`s taken courses : "+ student.takenCourses());
        log.warn("Adding some marks to student...");
        Enrollment enrollment = course.getEnrolledStudents().get(student);
        enrollment.addMark(84);
        enrollment.addMark(LocalDate.of(2021,3,15),64);
        enrollment.addMark(99);
        log.warn("Student`s avg mark to 2021.03.16 is : " + enrollment.getAverageToDate(LocalDate.of(2021,3,16)));
        log.warn("Student`s final mark is : " + enrollment.getFinalMark());
        log.warn("Unenrolling student...");
        student.unenroll(course);
    }
}
