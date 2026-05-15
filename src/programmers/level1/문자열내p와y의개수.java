package programmers.level1;

public class 문자열내p와y의개수 {
    public static class MySolution {
        boolean solution(String s) {

            s = s.toUpperCase();

            int pCount = 0;
            int yCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'P') pCount++;
                if (c == 'Y') yCount++;
            }

            return pCount == yCount;
        }
    }
}
