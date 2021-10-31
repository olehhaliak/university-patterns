import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public abstract class Person {

    @Getter
    @Setter
    private PersonalInfo personalInfo;
    @Getter
    private String violations = "";

    public Person(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public abstract float calculateWorkload();

    public void addViolation(String violation) {
        violations += violation + "\n";
    }

}
