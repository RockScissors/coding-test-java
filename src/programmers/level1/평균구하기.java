package programmers.level1;

public class 평균구하기 {
    public static class MySolution {
        public double solution(int[] arr) {
            double result;
            double sum = 0;
            int count = 0;
            for (int a : arr) {
                sum += a;
                count++;
            }
            result = sum / count;
            return result;
        }
    }
}
