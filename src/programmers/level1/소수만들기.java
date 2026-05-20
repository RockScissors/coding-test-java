package programmers.level1;

import java.util.HashMap;

public class 소수만들기 {
    public static class MySolution {
        public int solution(int[] nums) {
            int answer = 0;

            int[] sums = new int[(nums.length * (nums.length - 1) * (nums.length - 2)) / 6];

            int p1 = 0;
            int p2 = 1;
            int p3 = 2;
            for (int i = 0; i < sums.length; i++) {
                sums[i] = nums[p1] + nums[p2] + nums[p3++];
                if (p3 == nums.length) {
                    if (p2 == nums.length - 2) {
                        p1++;
                        p2 = p1 + 1;
                        p3 = p2 + 1;
                    } else {
                        p2++;
                        p3 = p2 + 1;
                    }
                }
            }

            outerLoop:
            for (int s : sums) {
                for (int i = 2; i <= Math.sqrt(s); i++) {
                    if (s % i == 0) continue outerLoop;
                }
                answer++;
            }


            return answer;
        }
    }

    // 가독성 개선

    public static class OptimalSolution {
        public int solution(int[] nums) {
            int answer = 0;

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (isPrime(sum)) answer++;
                    }
                }
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
}
