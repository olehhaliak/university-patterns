package edu.olehhaliak.patterns;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * by OlehHaliak
 */
@Slf4j
public class Professor extends Staff {

    Set<PostgraduateStudent> postgraduateStudents = new HashSet<>();

    public Professor(PersonalInfo personalInfo, LocalDate employedYear, int sallary) {
        super(personalInfo, employedYear, "edu.olehhaliak.patterns.Professor", sallary);
        log.info("edu.olehhaliak.patterns.Professor was created: " + this);
    }

    public Professor(PersonalInfo personalInfo, int sallary) {
        super(personalInfo, "edu.olehhaliak.patterns.Professor", sallary);
    }

    public void requestSupport(){
        throw new RuntimeException("Not yet implemented");
    }

    public void addPostgraduateStudent(PostgraduateStudent student) {
        postgraduateStudents.add(student);
    }

    @Override
    public float calculateWorkload() {
        //Complex logic goes here...
        return 1;
    }
}
