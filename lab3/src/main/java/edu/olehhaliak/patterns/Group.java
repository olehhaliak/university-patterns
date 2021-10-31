package edu.olehhaliak.patterns;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Getter
/**
 * Represents single group within course
 */
public class Group {
    private int id;
    private String name;
    private Map<Student, Enrollment> enrolledStudents;
    //"courseName :[link1,link2...]"
    Map<String, List<String>> courseMaterials;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        enrolledStudents = new HashMap<>();
        courseMaterials = new HashMap<>();
    }

    public void addStudent(Student student, Enrollment enrollment) {
        enrolledStudents.put(student, enrollment);
        log.info("Successfully added new edu.olehhaliak.patterns.Student : " + student.getPersonalInfo().getName());
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
        log.info("Successfully removed edu.olehhaliak.patterns.Student : " + student.getPersonalInfo().getName());
    }

    public void addCourseMaterial(String courseName,String material) {
        List<String> materialsForSelectedCourse = courseMaterials.getOrDefault(courseName,new ArrayList<String>());
        materialsForSelectedCourse.add(material);
        courseMaterials.put(courseName,materialsForSelectedCourse);
    }

}

