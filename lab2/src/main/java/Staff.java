import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class Staff extends Person {
    public Staff(PersonalInfo personalInfo, LocalDate employedYear, String position,int sallary) {
        super(personalInfo);
        this.employedYear = employedYear;
        this.position = position;
    }

    public Staff(PersonalInfo personalInfo, String position,int sallary) {
        this(personalInfo, LocalDate.now(), position,sallary);
    }
    private int sallary;
    private LocalDate employedYear;
    private String position;
}
