import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Slf4j
public class Enrollment {
    private Map<Date, Integer> receivedMarks = new HashMap<>();

    public Enrollment() {
        log.info("Enrollment was created");
    }

    public float getAverageToDate(Date date) {
        List<Integer> marksToDate = receivedMarks.entrySet().stream()
                .filter(E -> E.getKey().compareTo(date) > 0)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return getAverage(marksToDate);
    }

    public float getFinalMark() {
        return getAverage(receivedMarks.values());
    }

    private float getAverage(Collection<Integer> marks) {
        return marks.stream().reduce(Integer::sum).get() / (float) receivedMarks.size();
    }

}
