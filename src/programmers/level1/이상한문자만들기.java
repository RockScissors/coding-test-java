package programmers.level1;

public class 이상한문자만들기 {
    public static class MySolution {
        public String solution(String s) {
            char[] arr = s.toCharArray();
            int index = 0;

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (Character.isWhitespace(c)) {
                    index = 0;
                    continue;
                }
                arr[i] = index++ % 2 == 0
                        ? Character.toUpperCase(c)
                        : Character.toLowerCase(c);
            }

            return String.valueOf(arr);
        }
    }
}
