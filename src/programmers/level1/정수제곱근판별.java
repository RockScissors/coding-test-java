package programmers.level1;

public class 정수제곱근판별 {
    public static class MySolution {
        public long solution(long n) {
            double sqrt = Math.sqrt(n);
            if (sqrt != (long) sqrt) return -1;
            return (long) Math.pow(sqrt + 1, 2);
        }
    }
}
