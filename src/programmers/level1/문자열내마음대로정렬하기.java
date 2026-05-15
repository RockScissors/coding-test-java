package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    public static class MySolution {
        public String[] solution(String[] strings, int n) {
            String[] answer = Arrays.stream(strings)
                    .sorted(Comparator.comparing((String s) -> s.charAt(n))
                            .thenComparing(s -> s))
                    .toArray(String[]::new);
            return answer;
        }
    }
}
