package programmers.level2;

public class 멀리뛰기 {
    public static class MySolution {
        public long solution(int n) {
            long[] num = new long[]{1, 2}; // n-2칸, n-1칸 경우의 수
            long answer = 0;
            if (n == num[0]) return num[0]; // n=1
            if (n == num[1]) return num[1]; // n=2
            for (int i = 2; i < n; i++) {
                answer = num[0] + num[1];
                num[0] = num[1] % 1234567; // 다음에 쓸 값은 나머지만 남김
                // 모듈러 % 중복 : num[1]은 이미 나머지 값이라 불필요
                num[1] = answer % 1234567;
            }
            return answer % 1234567;
        }
    }

    // 처음 접근
    // 매 단계마다 (n번째마다) 1칸 개수, 2칸 개수를 n개-0개 부터 0개-2/n개까지 조절해가며
    // 1칸과 2칸 줄세우는 경우의 수 더하기 -> 2의 개수 t 정해 C(n-t, t) 합
    // 문제: 수가 너무 커져 중간에 long 크기에 담기지 못하고 넘침, 나눗셈 연산이라 mod(%) 사용 불가

    // 두 번째 접근
    // n번째 경우의 수는 (n-2번째 + 2칸 오르기) +(n-1번째 + 1칸 오르기) 인 피보나치로 접근
    // 문제 : 수가 너무 커져 중간에 long 크기에 담기지 못하고 넘침, 오버플로우

    // (a + b) % m = ((a % m) + (b % m)) % m  -> 합의 나머지 = 나머지끼리 합한 것의 나머지

    public static class OptimalSolution {
        public long solution(int n) {
            long[] sum = new long[n + 1];
            sum[0] = 1; sum[1] = 1;
            for (int i = 2; i <= n; i++) {
                sum[i] = (sum[i - 2] + sum[i - 1]) % 1234567;
            }
            return sum[n];
        }
    }
}
