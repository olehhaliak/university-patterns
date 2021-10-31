package edu.olehhaliak.patterns.course;

import edu.olehhaliak.patterns.Professor;

import java.time.LocalDate;

public class Calculus extends DefaultCourseImpl{
    private static final String NAME = "Calculus";
    public Calculus( LocalDate date, Professor professor, float fee) {
        super(NAME, date, professor, fee);
    }

    public Calculus(String name, LocalDate date, float fee) {
        super(NAME, date, fee);
    }
}
