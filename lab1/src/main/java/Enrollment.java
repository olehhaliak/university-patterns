import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Enrollment {
    private Map<Date, Integer> receivedMarks = new HashMap<>();


    float getAverageToDate(Date date) {
        List<Integer> marksToDate = receivedMarks.entrySet().stream()
                .filter(E -> E.getKey().compareTo(date) > 0)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return getAverage(marksToDate);
    }

    float getFinalMark() {
        return getAverage(receivedMarks.values());
    }

    private float getAverage(Collection<Integer> marks) {
        return marks.stream().reduce(Integer::sum).get() / (float) receivedMarks.size();
    }

}
