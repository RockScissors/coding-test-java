package programmers.level1;

public class 소수찾기 {
    public static class MySolution {
        public int solution(int n) {
            int answer = 0;

            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) answer++;
            }

            return answer;
        }

        private boolean isPrime(int n) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    // 1부터 N까지의 소수를 전부 다 찾아야 할 때
    // '에라토스테네스의 체 (Sieve of Eratosthenes)
    // 소수의 배수들은 무조건 소수가 아니다 -> 배열에서 배수를 지워 나감
    // O(N log log N)

    public static class OptimalSolution {
        public int solution(int n) {
            int answer = 0;

            boolean[] isNotPrime = new boolean[n + 1];

            isNotPrime[0] = true;
            isNotPrime[1] = true;

            for (int i = 2; i <= n; i++) {
                if (!isNotPrime[i]) {
                    answer++;

                    for (int j = i * i; j <= n; j += i) {
                        isNotPrime[j] = true;
                    }
                }
            }

            return answer;
        }
    }
}
