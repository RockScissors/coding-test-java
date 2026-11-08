package programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public static class MySolution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] remains = new int[progresses.length];
            for (int i = 0; i < progresses.length; i++) {
                int remain = 100 - progresses[i];
                int extraDay = remain % speeds[i] == 0? 0 : 1;
                remains[i] = remain / speeds[i] + extraDay;
            }

            List<Integer> deploys = new ArrayList<>();
            int day = Integer.MIN_VALUE;
            for (int i = 0; i < remains.length; i++) {
                if (day >= remains[i]) {
                    int idx = deploys.size() - 1;
                    deploys.set(idx, deploys.get(idx) + 1);
                } else {
                    deploys.add(1);
                    day = remains[i];
                }
            }

            return deploys.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    // 나눗셈의 ceil -> (a + b - 1) / b;
    // 문제 꼼꼼히 읽고 요구 조건 파악하기

    public static class OptimalSolution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < progresses.length; i++) {
                int left = 100 - progresses[i];
                q.offer((left + speeds[i] - 1) / speeds[i]);   // 올림 나눗셈
            }

            List<Integer> deployCounts = new ArrayList<>();
            while (!q.isEmpty()) {
                int front = q.poll();
                int count = 1;
                while (!q.isEmpty() && q.peek() <= front) {
                    q.poll();
                    count++;
                }
                deployCounts.add(count);
            }
            return deployCounts.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
