package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static class MySolution {
        public int solution(String[][] clothes) {
            Map<String, Integer> clothesType = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) { // for (String[] c : clothes)
                String type = clothes[i][1];
                int count = clothesType.getOrDefault(type, 0);
                clothesType.put(type, count + 1);
            }

            int answer = 1;
            for (String type : clothesType.keySet()) { // key로 값을 찾음
                answer *= clothesType.get(type) + 1; // get 재조회, values()로 바로 값 접근하도록 개선 가능
            }
            return answer - 1;
        }
    }

    // 2차원 배열을 향상된 for문으로 작성하면 -> for (String[] c : clothes)
    // map.keySet() , map.values()
    // map.entrySet() : 키-값 쌍, 둘 다 필요할 때
    // Map.Entry<K, V> : Map 안에 정의된 인터페이스

    public static class OptimalSolution {
        public int solution(String[][] clothes) {
            Map<String, Integer> countByType = new HashMap<>();
            for (String[] c : clothes) {
                String type = c[1];
                countByType.merge(type, 1, Integer::sum);
                // map.merge(key, 값, 합치는 규칙) : 키가 없으면 값을 그대로 넣고,
                // 있으면 (기존값 ,새값)에 규칙을 적용한 결과로 교체
                // = countByType.merge(type, 1, (a, b) -> a + b);

                // 예를 들어 이런 연산도 가능
                // map.merge(key, name, (oldName, newName) -> oldName + ", " + newName);
            }

            int answer = 1;
            for (int count : countByType.values()) {
                answer *= count + 1;
            }
            return answer - 1;
        }
    }
}
