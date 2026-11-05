package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    public static class MySolution {
        public int solution(int[] elements) {
            Set<Integer> sums = new HashSet<>();
            for (int i = 0; i < elements.length; i++) {
                for (int j = 0; j < elements.length; j++) {
                    int sum = 0;
                    for (int k = i; k <= i + j; k++) {
                        int idx = (k < elements.length)
                                ? k : k - elements.length;
                        sum += elements[idx];
                    }
                    sums.add(sum);
                }
            }
            return sums.size();
        }
    }

    // 변수명 명시적으로 (i -> start, j -> offset)
    // 시작점에서 길이가 1 늘면 합은 다음 칸 하나만 증가 -> sum 누적 (삼중 -> 이중 loop)

    public static class OptimalSolution {
        public int solution(int[] elements) {
            Set<Integer> sums = new HashSet<>();
            int len = elements.length;
            for (int start = 0; start < len; start++) {
                int sum = 0;
                for (int offset = 0; offset < len; offset++) {
                    sum += elements[(start + offset) % len];
                    sums.add(sum);
                }
            }
            return sums.size();
        }
    }
}
