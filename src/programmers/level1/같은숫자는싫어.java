package programmers.level1;

import java.util.Arrays;

public class 같은숫자는싫어 {
    public static class MySolution {
        public int[] solution(int[] arr) {
            int[] answer = new int[arr.length];
            answer[0] = arr[0];

            int count = 0;
            for(int i = 1; i < arr.length; i++) {
                if (arr[i-1] != arr[i]) {
                    answer[++count] = arr[i];
                }
            }
            answer = Arrays.copyOfRange(answer, 0, count + 1);


            return answer;
        }
    }
}
