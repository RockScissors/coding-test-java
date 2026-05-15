package programmers.level1;

public class 콜라문제 {
    public static class MySolution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            while(true){
                if(n < a) break;
                answer += b * (n / a);
                n = n - a * (n / a) + b * (n / a);
            }

            return answer;
        }
    }
}
