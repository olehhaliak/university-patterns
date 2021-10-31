import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * by OlehHaliak
 */
@Getter
@Setter
@Slf4j
public class Student extends Person {
    private float averageMark;
    private int year;

    private Map<Course, Enrollment> enrollments = new HashMap<>();

    public Student(PersonalInfo personalInfo, int year) {
        super(personalInfo);
        this.averageMark = 0;
        this.year = year;
        log.info("Student was created: " + this);
    }

    public boolean canEnroll(Course course) {
        return true; //Since we don`t have any requirements for enrollment yet, lets assume that Student always can enroll
    }

    Set<Course> takenCourses() {
        return enrollments.keySet();
    }

    void enroll(Course course) {
        if (!canEnroll(course)) {
            throw new RuntimeException("Failed enrolling to course " + course.getName() + " - this student in not eligible to enroll it");
        }
        Enrollment newEnrollment = new Enrollment();
        course.addStudent(this, newEnrollment);
        enrollments.put(course, newEnrollment);
        log.info("Successfully enrolled to course : " + course.getName());
    }

    void unenroll(Course course) {
        course.removeStudent(this);
        enrollments.remove(course);
        log.info("Successfully unenrolled from course : " + course.getName());
    }

    @Override
    public float calculateWorkload() {
        //Complex calculations goes here...
        return 1;
    }

    public void visitSeminar(Seminar seminar) {
        String courseName = seminar.getRelatedCourse();
        Course relatedCourse = enrollments.keySet().stream()
                .filter(C -> C.getName().equals(courseName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("this student does not have any course related to this seminar"));
        enrollments.get(relatedCourse).addAttendanceRecord(seminar);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Float.compare(student.averageMark, averageMark) == 0 && year == student.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageMark, year);
    }

    @Override
    public String toString() {
        return "Student{" +
                "averageMark=" + averageMark +
                ", year=" + year +
                '}';
    }
}
