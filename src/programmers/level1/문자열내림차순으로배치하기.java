package programmers.level1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {
    public static class MySolution {
        public String solution(String s) {
            char[] sortedArr = s.toCharArray();

            Arrays.sort(sortedArr);

            char[] reversedArr = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                reversedArr[i] = sortedArr[s.length() - i - 1];
            }

            return String.valueOf(reversedArr);
        }
    }
}
