import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Slf4j
public abstract class Course {
    protected String name;
    protected LocalDate date;
    protected List<Seminar> seminars;
    protected float fee;
    protected Professor professor;
    protected Map<Student, Enrollment> enrolledStudents = new HashMap<>();

    public Course(String name, LocalDate date, Professor professor, float fee) {
        this.name = name;
        this.date = date;
        this.seminars = new LinkedList<>();
        this.fee = fee;
        log.info("Course was created: " + this);
    }

    public Course(String name, LocalDate date,  float fee) {
        this(name, date, null, fee);
    }

    public abstract void addStudent(Student student, Enrollment enrollment);

    public abstract void removeStudent(Student student) ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Float.compare(course.fee, fee) == 0 && Objects.equals(name, course.name) && Objects.equals(date, course.date) && Objects.equals(seminars, course.seminars) && Objects.equals(professor, course.professor) && Objects.equals(enrolledStudents, course.enrolledStudents);
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
