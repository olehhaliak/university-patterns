import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter

public class Student {

    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private int studentNumber;
    private float averageMark;
    private Map<Course, Enrollment> enrollments = new HashMap<>();

    public Student(String name, String address, String phoneNumber, String email, int studentNumber, float averageMark) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studentNumber = studentNumber;
        this.averageMark = averageMark;
    }

    public boolean canEnroll(Course course) {
        return true; //Since we don`t have any requirements for enrollment yet, lets assume that Student always can enroll
    }

    Set<Course> takenCourses() {
        return enrollments.keySet();
    }

    void enroll(Course course) {
        if (!canEnroll(course)) {
            throw new RuntimeException();
        }
        Enrollment newEnrollment = new Enrollment();
        course.addStudent(this,newEnrollment);
        enrollments.put(course, newEnrollment);
    }

    void unenroll(Course course) {
        course.removeStudent(this);
        enrollments.remove(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber && Float.compare(student.averageMark, averageMark) == 0 && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, email, studentNumber, averageMark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", studentNumber=" + studentNumber +
                ", averageMark=" + averageMark +
                '}';
    }
}
