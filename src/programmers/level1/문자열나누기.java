package programmers.level1;

public class 문자열나누기 {
    public static class MySolution {
        public int solution(String s) {
            int xCount = 0;
            int answer = 1;

            char[] c = s.toCharArray();
            char x = c[0];

            for (int i = 0; i < s.length() - 1; i++) {
                xCount = c[i] == x? xCount + 1 : xCount - 1;
                if (xCount == 0) {
                    answer++;
                    x = c[i + 1];
                }
            }

            return answer;
        }
    }
}
