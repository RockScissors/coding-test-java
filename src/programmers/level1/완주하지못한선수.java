package programmers.level1;

import java.util.HashMap;

public class 완주하지못한선수 {

    public static class MySolution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> completionMap = new HashMap<>();

            for (String c : completion) {
                completionMap.put(c, completionMap.getOrDefault(c, 0) + 1);
            }

            for (String p : participant) {
                if (!completionMap.containsKey(p)) return p;
                else {
                    int reduceCount = completionMap.get(p) - 1;
                    if (reduceCount == -1) return p;
                    else completionMap.put(p, reduceCount);
                }
            }

            return "";
        }
    }

    // 1. 변수명 개선 reduceCount -> remainCount, remaining
    // 2. containsKey + get 중복 조회
    // 3. count == -1 보다 count == 0 조건이 자연스러움
    // (4. completionMap -> completionCount, map)

    public static class OptimalSolution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String, Integer> map = new HashMap<>();

            for (String c : completion) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (String p : participant) {
                Integer remainCount = map.get(p);
                if (remainCount == null || remainCount == 0) return p;
                map.put(p, remainCount - 1);
            }

            return "";
        }
    }
}
