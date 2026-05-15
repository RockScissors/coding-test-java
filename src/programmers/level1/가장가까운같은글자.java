package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {
    public static class MySolution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            char[] chars = s.toCharArray();
            Map<Character, Integer> alphMap = new HashMap<>();

            for (int i = 0; i < chars.length; i++) {
                if (alphMap.containsKey(chars[i])) {
                    int beforeIndex = alphMap.get(chars[i]);
                    answer[i] = i - beforeIndex;
                    alphMap.put(chars[i], i);
                } else {
                    alphMap.put(chars[i], i);
                    answer[i] = -1;
                }
            }

            return answer;
        }
    }
}
