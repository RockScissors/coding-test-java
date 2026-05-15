package programmers.level1;

public class 짝수와홀수 {
    public static class MySolution {
        public String solution(int num) {
            return (num % 2 == 0)
                    ? "Even"
                    : "Odd";
        }
    }
}
