package programmers.level1;

public class 자연수뒤집어배열로만들기 {
    public static class MySolution {
        public int[] solution(long n) {
            int length = String.valueOf(n).length();
            int[] answer = new int[length];

            for (int i = 0; i < length; i++) {
                answer[i] = (int) (n % 10);
                n /= 10;
            }
            return answer;
        }
    }
}
