package programmers.level1;

public class 덧칠하기 {
    public static class MySolution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int endPart = 0;

            for (int i = 0; i < section.length; i++) {
                if (endPart >= n) break;
                if (section[i] <= endPart) continue;
                endPart = section[i] + m - 1;
                answer++;
            }

            return answer;
        }
    }
}
