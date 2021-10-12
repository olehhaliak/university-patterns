import lombok.extern.slf4j.Slf4j;

/**
 * by OlehHaliak
 */
@Slf4j
public class Professor {
    String name;
    String adress;
    String phoneNumber;
    String email;
    float sallary;

    public Professor(String name, String adress, String phoneNumber, String email, float sallary) {
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.sallary = sallary;
        log.info("Professor was created: "+ this);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", sallary=" + sallary +
                '}';
    }
}
