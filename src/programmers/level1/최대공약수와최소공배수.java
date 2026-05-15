package programmers.level1;

public class 최대공약수와최소공배수 {
    public static class MySolution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];

            answer[0] = getGCD(n, m);
            answer[1] = n * (m / getGCD(n, m));

            return answer;
        }

        private int getGCD(int n, int m) {
            int divisor = 0;
            int gcd = 1;

            if(Math.max(n, m) % Math.min(n, m) == 0) return Math.min(n, m);

            while(Math.min(n, m) / 2 >= divisor){
                divisor++;
                if(n % divisor == 0 && m % divisor == 0) {
                    gcd *= divisor;
                    n /= divisor;
                    m /= divisor;
                    divisor = 1;
                }
            }

            return gcd;
        }
    }
}
