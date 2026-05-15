package programmers.level1;

import java.util.HashMap;

public class 대충만든자판 {

    public static class MySolution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            HashMap<String, Integer> pressMap = new HashMap<>();

            for (String key : keymap) {
                for (int i = 0; i < key.length(); i++) {
                    String s = String.valueOf(key.charAt(i));
                    if (pressMap.containsKey(s)) {
                        pressMap.put(s, Math.min(pressMap.get(s), i + 1));
                    } else {
                        pressMap.put(s, i + 1);
                    }
                }
            }

            for (int i = 0; i < targets.length; i++) {
                for (int j = 0; j < targets[i].length(); j++) {
                    String s = String.valueOf(targets[i].charAt(j));

                    if (!pressMap.containsKey(s)) {
                        answer[i] = -1;
                        break;
                    }

                    answer[i] += pressMap.get(s);
                }
            }

            return answer;
        }
    }

}
