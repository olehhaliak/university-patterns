import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;

/**
 * by OlehHaliak
 */
@Slf4j
public class CourseImpl extends Course{

    public CourseImpl(String name, LocalDate date, Professor professor, float fee) {
        super(name,date,professor,fee);
    }

    public CourseImpl(String name, LocalDate date,  float fee) {
        super(name,date,fee);
    }

    public void addStudent(Student student, Enrollment enrollment) {
        enrolledStudents.put(student, enrollment);
        log.info("Successfully added new Student : " + student.getPersonalInfo().getName());
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
        log.info("Successfully removed Student : " + student.getPersonalInfo().getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseImpl courseImpl = (CourseImpl) o;
        return Float.compare(courseImpl.fee, fee) == 0 && Objects.equals(name, courseImpl.name) && Objects.equals(date, courseImpl.date) && Objects.equals(seminars, courseImpl.seminars) && Objects.equals(professor, courseImpl.professor) && Objects.equals(enrolledStudents, courseImpl.enrolledStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, seminars, fee, professor, enrolledStudents);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", seminars=" + seminars +
                ", fee=" + fee +
                ", professor=" + professor +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}

