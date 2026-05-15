package programmers.level1;

public class 크기가작은부분문자열 {
    public static class MySolution {
        public int solution(String t, String p) {
            int answer = 0;

            for (int i = 0; i <= t.length() - p.length(); i++) {
                if (Long.parseLong(p) >= Long.parseLong(t.substring(i, i + p.length()))) answer++;
            }

            return answer;
        }
    }
}
