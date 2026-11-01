package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String[] arr = s.split(" ");

        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        for (String a : arr) {
            min = Math.min(min, Integer.parseInt(a));
            max = Math.max(max, Integer.parseInt(a));
        }

        String answer = min + " " + max;
        return answer;
    }

    public static class OptimalSolution {
        public String solution(String s) {
            String[] arr = s.split(" ");

            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;

            for (int i = 1; i < arr.length; i++) {
                int n = Integer.parseInt(arr[i]);
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
            return min + " " + max;
        }
    }

    // 스트림
    public class StreamSolution {
        public String solution(String s) {
            List<Integer> list = Arrays.stream(s.split(" "))
                    .map(x -> Integer.parseInt(x)).toList();
            return Collections.min(list) + " " + Collections.max(list);
            // List에는 min, max 존재 X. Collections.min, Collections.max 사용
        }
    }
    // Arrays.stream(arr).mapToInt(Integer::parseInt).toArray() // String[] -> int[]
    // list.stream().mapToInt(Integer::intValue).toArray() // List<Integer> -> int[]
    // Arrays.stream(a).sum() / .max().getAsInt() / .min().getAsInt() // int[] 집계
}
