package programmers.level2;

import java.util.*;

public class 프로세스 {
    public static class MySolution {
        public int solution(int[] priorities, int location) {
            int answer = 1;

            // queue에 priorities 삽입
            Queue<Integer> q = new ArrayDeque<>();
            for (int p : priorities) {
                q.offer(p);
            }

            // priorities 오름차순 정렬 후 뒤집어 descP(내림차순)에 담기
            Arrays.sort(priorities);
            int pLen = priorities.length;
            int[] descP = new int[pLen];
            for (int i = 0; i < pLen; i++) {
                descP[i] = priorities[pLen - i - 1];
            }

            // 우선순위 높은 것부터 하나씩 실행하며 큐 순환
            for (int i = 0; i < descP.length; ) { // i : 지금 실행 중인 우선순위 위치
                int p = q.poll();
                if (p == descP[i]) { // 남은 것 중 최대 -> 실행
                    if (location == 0) break; // 찾는 프로세스면 종료
                    answer++;
                    i++;
                } else {
                    q.offer(p); // 아니면 다시 큐 뒤에 삽입
                }
                // 찾는 프로세스 위치 갱신
                location = location - 1 < 0? q.size() - 1 : location - 1;
            }
            return answer;
        }
    }

    // Arrays.sort(배열, 비교자)는 Integer[] 같은 객체 배열에만 가능
    // ex) Arrays.sort(Integer[] , (a, b) -> a - b) : 오름차순 배열
    // Arrays에는 reverse 존재 x, 뒤집기는 Collections.reverse(List)만

    // PriorityQueue : 기본 최소 힙 (오름차순)
    // -> Collections.reverseOrder()로 최대 힙 (내림차순)
    // 우선순위 큐 -> 넣은 순서에 상관 없이, 우선순위가 가장 높은 것이 먼저 출력
    // 내부가 전부 정렬되어 있는 것은 X, 내부는 힙. 맨 앞 하나만 항상 정확

    public static class OptimalSolution {
        public int solution(int[] priorities, int location) {
            Queue<int[]> q = new ArrayDeque<>(); // {원래 위치, 우선순위}
            // -> 위치를 큐에 같이 넣어 추적 (location 계산 생략)
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            // new PriorityQueue<>(...) 괄호 안은 '누가 먼저인가'의 규칙(Comparator)을 넣는 자리
            // 비워두면 기본 규칙 -> 우선순위 큐의 경우 작은 값이 먼저, 최소 힙
            // Comparator는 compare(a, b)가 음수면 a가 먼저, 양수면 b가 먼저라는 규칙

            for (int i = 0; i < priorities.length; i++) {
                q.offer(new int[]{i, priorities[i]});
                pq.offer(priorities[i]);
            }

            int order = 0;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[1] == pq.peek()) { // 남은 것 중 최고 우선순위인지 확인
                    order++;
                    pq.poll();
                    if (cur[0] == location) return order;
                } else {
                    q.offer(cur);
                }
            }
            return order;
        }
    }
}
