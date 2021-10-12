import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * by OlehHaliak
 */
@Data
@Slf4j
public class Enrollment {
    private List<Mark> receivedMarks = new ArrayList<>();

    public Enrollment() {
        log.info("Enrollment was created");
    }

    public float getAverageToDate(LocalDate date) {
        List<Mark> marksToDate = receivedMarks.stream()
                .filter(E->E.date.isBefore(date)||E.date.isEqual(date))
                .collect(Collectors.toList());
        return getAverage(marksToDate);
    }

    public float getFinalMark() {
        return getAverage(receivedMarks);
    }

    public void addMark(Integer mark) {
        addMark(LocalDate.now(), mark);
    }

    public void addMark(LocalDate date, Integer mark) {
        receivedMarks.add(new Mark(date, mark));
        log.info("Added new Mark: " + mark + ";received at " + date);
    }

    private float getAverage(Collection<Mark> marks) {
        int sum = 0;
        for (Mark mark : marks) {
            sum += mark.value;
        }
        return sum / (float) marks.size();
    }

    private class Mark {
        public Mark(LocalDate date, Integer value) {
            this.date = date;
            this.value = value;
        }

        LocalDate date;
        Integer value;
    }
}
