package programmers.level1;

public class 둘만의암호 {
    public static class MySolution {
        public String solution(String s, String skip, int index) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                int tempIdx = index;
                char c = s.charAt(i);

                while (tempIdx > 0) {
                    c = (char) (c + 1);
                    if (c > 'z') c = 'a';
                    if (skip.indexOf(c) == -1) tempIdx--;
                    else continue;
                }

                sb.append(c);
            }

            return sb.toString();
        }
    }
}
