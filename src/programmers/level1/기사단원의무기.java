package programmers.level1;

public class 기사단원의무기 {
    public static class MySolution {
        public int solution(int number, int limit, int power) {
            int answer = 1;

            if (limit == 0) return 0;

            for(int i = 2; i <= number; i++) {
                int p = 0;
                for(int j = 1; j <= i / 2; j++) {
                    if (i % j == 0) p++;
                    if (i != 1 && j == i / 2) p++;
                    if (p > limit) {
                        p = power;
                        break;
                    }
                }
                answer += p;
            }

            return answer;
        }
    }
}
