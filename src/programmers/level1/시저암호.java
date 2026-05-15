package programmers.level1;

public class 시저암호 {
    public static class MySolution {
        public String solution(String s, int n) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') continue;
                if (chars[i] >= 'a' && chars[i] <= 'z') {
                    chars[i] = (char)(((chars[i] - 'a' + n) % 26) + (int) 'a');
                }
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    chars[i] = (char)(((chars[i] - 'A' + n) % 26) + (int) 'A');
                }
            }

            return String.valueOf(chars);
        }
    }
}
