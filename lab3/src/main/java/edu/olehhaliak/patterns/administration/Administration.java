package edu.olehhaliak.patterns.administration;

import edu.olehhaliak.patterns.Group;
import edu.olehhaliak.patterns.PersonalInfo;
import edu.olehhaliak.patterns.Professor;
import edu.olehhaliak.patterns.course.Course;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Administration {
    protected PersonalInfo personalInfo;
    protected List<Course> courses;

    public Administration(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
        this.courses = new ArrayList<>();
    }

    /**
     * creates courses based on params and insert them into courses list
     *
     * @param professor
     * @param group
     */
    public abstract void fillCourse(Professor professor, Group group);

    /**
     * @return list of courses that were generated by fillCourse()
     */
    public List<Course> attachCourse() {
        return courses;
    }

}
