import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Andrew", "Lviv,Sikorskoho 44", "+0954323111", "andy@g.com", 1, 84);
        Professor professor = new Professor("George", "Drohobych, Sambirska st., 44/15", "+380962121112", "georgy@g.com", 9500);
        Course course = new Course("applied math", new Date(System.currentTimeMillis()),professor, 15, 8500);
        student.enroll(course);

    }
}
