package programmers.level1;

import java.time.LocalDate;

public class _2016년 {
    public static class MySolution {
        public String solution(int a, int b) {
            LocalDate date = LocalDate.of(2016, a, b);
            String day = date.getDayOfWeek().toString();
            return day.substring(0, 3);
        }
    }
}
