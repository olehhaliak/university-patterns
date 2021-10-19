import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class PostgraduateStudent extends Student{
    private String PHDStatus;

    public PostgraduateStudent(PersonalInfo personalInfo, int year, String PHDStatus) {
        super(personalInfo, year);
        this.PHDStatus = PHDStatus;
    }
}
