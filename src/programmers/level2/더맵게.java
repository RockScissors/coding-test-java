package programmers.level2;

import java.util.PriorityQueue;

public class 더맵게 {
    public static class MySolution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) {
                pq.offer(s);
            }

            int count = 0;
            int leastSpicy = pq.poll(); // 가장 안 매운 음식
            while (leastSpicy < K) { // 가장 안 매운 음식이 K 이상이면 전부 K 이상
                if (pq.isEmpty()) return -1; // 하나 남았는데 K 미만 -> 불가능
                pq.offer(leastSpicy + pq.poll() * 2);
                leastSpicy = pq.poll(); // 섞은 결과까지 포함해서 다시 가장 안 매운 것 poll
                count++;
            }
            return count;
        }
    }

    // 오버플로우 주의! 섞은 값이 int 범위를 넘을 수 있었음
    // PriorityQueue<Long> 으로 바꾸고, 섞은 값을 long에 담기
    // 우선순위 큐는 내부적으로 힙 -> 정렬 O(log n)
    // (+) PriorityBlockingQueue : 스레드 안전한 힙

}
