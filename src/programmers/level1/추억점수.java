package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class 추억점수 {
    public static class MySolution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];

            Map<String, Integer> yearningMap = new HashMap<>();

            for(int i = 0; i < yearning.length; i++) {
                yearningMap.put(name[i], yearning[i]);
            }

            for(int i = 0; i < photo.length; i++) {
                for(int j = 0; j < photo[i].length; j++) {
                    int yearningScore = Optional.ofNullable(yearningMap.get(photo[i][j]))
                            .orElse(0);
                    answer[i] += yearningScore;
                }
            }

            return answer;
        }
    }
}
