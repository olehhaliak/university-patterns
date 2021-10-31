import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;


@Data
@Slf4j
public class Seminar {

    private int id;
    private String title;
    private LocalDate deadline;
    private List<String> items;
    private float status;
    private String relatedCourse;
    @Setter(value = AccessLevel.NONE)
    private String comments = "";

    public Seminar(int id, String title, LocalDate deadline, List<String> items, float status, String relatedCourse, String comments) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.items = items;
        this.status = status;
        this.relatedCourse = relatedCourse;
        this.comments = comments;
    }

    public Seminar() {
    }

    public String implementItem(String item) {
        log.info("Seminar:Implementing item: " + item);
        return item;
    }

    public void addComment(Staff staffMember, String message) {
        comments += staffMember.getPersonalInfo().getName() + " : " + message + "\n";
    }

}
