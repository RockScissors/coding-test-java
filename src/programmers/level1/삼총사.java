package programmers.level1;

public class 삼총사 {
    public static class MySolution {
        public int solution(int[] number) {
            int answer = 0;
            int sum;

            for (int i = 0; i < number.length - 2; i++) {
                for (int j = i + 1; j < number.length - 1; j++) {
                    for (int k  = j + 1; k < number.length; k++) {
                        sum = number[i] + number[j] + number[k];
                        if (sum == 0) answer++;
                    }
                }
            }

            return answer;
        }
    }
}
