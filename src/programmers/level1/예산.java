package programmers.level1;

import java.util.Arrays;

public class 예산 {
    public static class MySolution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);

            int sum = 0;
            int answer = 0;
            for (int i = 0; i < d.length; i++) {
                sum += d[i];
                if (sum > budget) break;
                answer++;
            }

            return answer;
        }
    }
}
