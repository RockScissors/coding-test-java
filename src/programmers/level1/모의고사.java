package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    public static class MySolution {
        public int[] solution(int[] answers) {
            int[][] students = {
                    {1, 2, 3, 4, 5},
                    {2, 1, 2, 3, 2, 4, 2, 5},
                    {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            };

            int[] countSt = new int[3];

            for (int i = 0; i < answers.length; i++) {
                for (int j = 0; j < 3; j++) {
                    if (answers[i] == students[j][i % students[j].length]) countSt[j]++;
                }
            }

            List<Integer> answerList = new ArrayList<>();
            int max = Math.max(Math.max(countSt[0], countSt[1]), countSt[2]);
            for (int i = 0; i < 3; i++) {
                if (countSt[i] == max) answerList.add(i + 1);
            }

            return answerList.stream().mapToInt(i -> i.intValue()).toArray();
        }
    }
}
