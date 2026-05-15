package programmers.level1;

public class 두정수사이의합 {
    public static class MySolution {
        public long solution(int a, int b) {
            if (a == b) return a;

            int bigNum = a > b? a : b;
            int smallNum = a > b? b : a;
            long sum = 0;

            for (int i = 0; i <= (bigNum - smallNum); i++) {
                sum = sum + (smallNum + i);
            }
            return sum;
        }
    }
}
