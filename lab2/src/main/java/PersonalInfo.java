import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonalInfo {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}