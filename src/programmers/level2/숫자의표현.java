package programmers.level2;

public class 숫자의표현 {
    public static class MySolution {
        public int solution(int n) {
            if (n == 1) return 1;

            int answer = 1;
            for (int i = 1; i <= n / 2; i++) {
                int x = i;
                for (int j = i + 1; j <= n / 2 + 1; j++) {
                    x += j;
                    if (x > n) break;
                    if (x == n) {
                        answer++;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    // 연속되는 수의 합 -> 시작점, 끝점을 정하면 개수가 자연히 정해짐

    public static class OptimalSolution {
        // 투 포인터
        public int solution(int n) {
            int answer = 0;
            int left = 1, right = 1, sum = 1;
            while (left <= n) {
                if (sum < n) { // 모자라면 오른쪽 한 칸 늘림
                    right++;
                    sum += right;
                } else { // 같거나 크면 왼쪽 한 칸 늘림
                    if (sum == n) answer++;
                    sum -= left;
                    left++;
                }
            }
            return answer;
        }
    }
}
