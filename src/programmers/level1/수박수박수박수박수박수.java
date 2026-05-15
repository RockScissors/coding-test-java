package programmers.level1;

public class 수박수박수박수박수박수 {
    public static class MySolution {
        public String solution(int n) {
            if(n==1) return "수";

            String answer = "수박";
            answer = answer.repeat(n/2);
            return n % 2 == 0
                    ? answer
                    : answer + "수";
        }
    }
}
