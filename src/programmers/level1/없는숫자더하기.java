package programmers.level1;

import java.util.Arrays;

public class 없는숫자더하기 {
    public static class MySolution {
        public int solution(int[] numbers) {
            return 45 - Arrays.stream(numbers).sum();
        }
    }
}
