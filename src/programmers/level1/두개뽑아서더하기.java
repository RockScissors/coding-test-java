package programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 두개뽑아서더하기 {
    public static class MySolution {
        public int[] solution(int[] numbers) {
            int[] answer = {};
            List<Integer> answerList = new ArrayList<>();

            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i+1; j < numbers.length; j++) {
                    answerList.add(numbers[i] + numbers[j]);
                }
            }

            answerList = answerList.stream().distinct().sorted()
                    .collect(Collectors.toList());
            answer = new int[answerList.size()];
            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
    }
}
