package edu.olehhaliak.patterns.course;

import edu.olehhaliak.patterns.*;
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
    protected List<Group> groups;
    public Course(String name, LocalDate date, Professor professor, float fee) {
        this.name = name;
        this.date = date;
        this.seminars = new LinkedList<>();
        this.fee = fee;
        groups = new ArrayList<>();
        log.info("edu.olehhaliak.patterns.course.Course was created: " + this);
    }

    public Course(String name, LocalDate date,  float fee) {
        this(name, date, null, fee);
    }

    public abstract void addStudent(Student student, Enrollment enrollment);

    public abstract void addStudentToGroup(Student student,Enrollment enrollment, Group group);

    public abstract void removeStudent(Student student) ;

    public abstract void sendCourseMaterials(Group group,String material);

    /**
     * @return all materials returned to this group, if this course does not contain group specified, then returns empty list
     */
    public abstract Collection<String> getCourseMaterials(Group group) ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Float.compare(course.fee, fee) == 0 && Objects.equals(name, course.name) && Objects.equals(date, course.date) && Objects.equals(seminars, course.seminars) && Objects.equals(professor, course.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, seminars, fee, professor);
    }

    @Override
    public String toString() {
        return "edu.olehhaliak.patterns.course.Course{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", seminars=" + seminars +
                ", fee=" + fee +
                ", professor=" + professor +
                '}';
    }
}
