package programmers.level1;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    public static class MySolution {
        public int[] solution(int[] arr, int divisor) {
            int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
            return answer.length == 0? new int[]{-1} : answer;
        }
    }
}
