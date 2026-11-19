package programmers.level2;

public class _2xN타일링 {
    public static class MySolution{
        class Solution {
            public int solution(int n) {
                int[] cases = new int[n + 1];
                cases[0] = 1; cases[1] = 1;
                for (int i = 2; i <= n; i++) {
                    cases[i] = (cases[i - 2] + cases[i - 1]) % 1000000007;
                }
                return cases[n];
            }
        }

        // level2 멀리뛰기와 같은 점화식
        // 길이가 n인 직사각형을 채우는 경우의 수는
        // (n-2인 경우 + 타일 가로 눕히기 -2칸) + (n-1인 경우 + 타일 세로 세우기 -1칸)
    }
}
