package programmers.level1;

public class 약수의개수와덧셈 {
    public static class MySolution {
        public int solution(int left, int right) {
            int answer = 0;

            for (int i = left; i <=right; i++) {
                int divisorCount = countDivisors(i);
                answer += (divisorCount % 2 == 0)
                        ? i : -i;
            }

            return answer;
        }

        private int countDivisors(int num) {
            int count = 1;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) count++;
            }
            return count;
        }
    }
}
