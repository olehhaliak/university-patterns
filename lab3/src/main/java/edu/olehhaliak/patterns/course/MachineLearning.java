package edu.olehhaliak.patterns.course;

import edu.olehhaliak.patterns.Professor;

import java.time.LocalDate;

public class MachineLearning extends DefaultCourseImpl{
    private static final String NAME = "Calculus";

    public MachineLearning( LocalDate date, Professor professor, float fee) {
        super(NAME, date, professor, fee);
    }

    public MachineLearning(LocalDate date, float fee) {
        super(NAME, date, fee);
    }
}
