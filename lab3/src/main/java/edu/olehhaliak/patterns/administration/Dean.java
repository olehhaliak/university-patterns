package edu.olehhaliak.patterns.administration;

import edu.olehhaliak.patterns.Group;
import edu.olehhaliak.patterns.PersonalInfo;
import edu.olehhaliak.patterns.Professor;
import edu.olehhaliak.patterns.course.Calculus;
import edu.olehhaliak.patterns.course.Course;

import java.time.LocalDate;

public class Dean extends Administration{
    private static final int DEFAULT_FEE = 15000;

    public Dean(PersonalInfo personalInfo) {
        super(personalInfo);
    }

    @Override
    public void fillCourse(Professor professor, Group group) {
        Course calculus = new Calculus(LocalDate.now(),professor,DEFAULT_FEE);
        calculus.getGroups().add(group);
        courses.add(calculus);
    }

}
