package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 성격유형검사하기 {
    public static class MySolution {
        public String solution(String[] survey, int[] choices) {
            int[] choiceScore = {0, -3, -2, -1, 0, 1, 2, 3};

            Set<String> rightDirectionSet = Set.of("RT", "CF", "JM", "AN");

            Map<String, Integer> map = new HashMap<>(
                    Map.of(
                            "RT", 0, "TR", 0,
                            "CF", 1, "FC", 1,
                            "JM", 2, "MJ", 2,
                            "AN", 3, "NA", 3)
            );

            int[] resultScore = {0, 0, 0, 0}; // RT, CF, JM, AN - 음수 R, 양수 T

            for (int i = 0; i < survey.length; i++) {
                int n = rightDirectionSet.contains(survey[i])? 1 : -1;
                resultScore[map.get(survey[i])] += choiceScore[choices[i]] * n;
            }

            String RorT = resultScore[0] <= 0? "R" : "T";
            String CorF = resultScore[1] <= 0? "C" : "F";
            String JorM = resultScore[2] <= 0? "J" : "M";
            String AorN = resultScore[3] <= 0? "A" : "N";

            return RorT + CorF + JorM + AorN;
        }
    }

    // 코드의 가독성 부족, 직관적이지 못함

    public static class OptimalSolution {
        public String solution(String[] survey, int[] choices) {
            // 각 성격 유형 알파벳이 얻은 점수를 기록할 Map (초기값 0)
            Map<Character, Integer> scoreMap = new HashMap<>();

            char[][] types = {
                    {'R', 'T'},
                    {'C', 'F'},
                    {'J', 'M'},
                    {'A', 'N'}
            };

            // 설문 조사 점수 계산
            for (int i = 0; i < survey.length; i++) {
                char disagreeChar = survey[i].charAt(0); // 비동의 시 점수를 얻는 앞글자
                char agreeChar = survey[i].charAt(1);    // 동의 시 점수를 얻는 뒷글자
                int choice = choices[i];

                if (choice < 4) { // 1, 2, 3 (비동의 쪽)
                    int score = 4 - choice;
                    scoreMap.put(disagreeChar, scoreMap.getOrDefault(disagreeChar, 0) + score);
                } else if (choice > 4) { // 5, 6, 7 (동의 쪽)
                    int score = choice - 4;
                    scoreMap.put(agreeChar, scoreMap.getOrDefault(agreeChar, 0) + score);
                }
            }

            // 마지막 로직 반복문 처리
            StringBuilder sb = new StringBuilder();
            for (char[] type : types) {
                int leftScore = scoreMap.getOrDefault(type[0], 0);
                int rightScore = scoreMap.getOrDefault(type[1], 0);

                // 점수가 같거나 왼쪽이 크면 왼쪽 알파벳, 오른쪽이 크면 오른쪽 알파벳
                if (leftScore >= rightScore) {
                    sb.append(type[0]);
                } else {
                    sb.append(type[1]);
                }
            }

            return sb.toString();
        }
    }
}
