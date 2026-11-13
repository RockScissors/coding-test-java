package programmers.level2;

import java.util.*;

public class 귤고르기 {
    public static class MySolution {
        public int solution(int k, int[] tangerine) {
            Map<Integer, Integer> sizeMap = new HashMap<>(); // 크기-개수 map
            for (int t : tangerine) {
                sizeMap.merge(t, 1, Integer::sum);
            }

            // {크기, 개수} 쌍 배열
            int[][] sizeArr = new int[sizeMap.keySet().size()][2];
            int idx = 0;
            for (int i : sizeMap.keySet()) {
                sizeArr[idx][0] = i;
                sizeArr[idx][1] = sizeMap.get(i);
                idx++;
            }

            // 개수 내림차순 정렬
            Arrays.sort(sizeArr, (a, b) -> b[1] - a[1]);

            int sizeCount = 0;
            int totalCount = 0;
            for (int[] i : sizeArr) {
                if (totalCount >= k) break;
                sizeCount++;
                totalCount += i[1];
            }

            return sizeCount;
        }
    }

    // size 필요없엇음
    // 크기(key)는 세는 동안에만 필요, 출력은 '크기 종류의 수'이므로 그룹별 개수만 필요

    // Arrays.sort(배열, 비교자) : sort(T[] a, Comparator<? super T> c) T는 객체여야 함
    // 예를 들어 int[]의 경우 int는 프리미티브 타입으로 객체가 아니기에 비교자 사용 불가
    // int[][]의 경우, 원소가 int[]로 배열(객체)이기에 가능

    // PriorityQueue<E> : E는 어떤 타입이든 가능 (Integer, int[], List, 직접 만든 클래스...)
    // 우선순위 기준 = 생성자의 Comparator
    // Comparator를 따로 주지 않는 경우 원소가 Comparable이어야 함 (Integer, Long, String은 가능)
    // Comparable하지 않은 객체를 (ex. int[], List...) Comparator 없이 넣으면 ClassCastException 발생
    // ex) new PriorityQueue<int[]>((a, b) -> b[1] - a[1]) 처럼도 사용 가능

    // Map 메서드 : keySet() -> 키 Set / values() -> 값 Collection
    // (+. values()는 collection이라 get(i), sort를 바로 사용하지 못함
    // new ArrayList<>(map.values())로 복사해 사용해야 함)
    // entrySet() -> {키, 값} 쌍의 Set (Map.Entry)
    // 그 외 : put, get, getOrDefault, containsKey, remove, size, merge

    public static class OptimalSolution {
        public int solution(int k, int[] tangerine) {
            Map<Integer, Integer> sizeMap = new HashMap<>();
            for (int t : tangerine) {
                sizeMap.merge(t, 1, Integer::sum);
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            pq.addAll(sizeMap.values());
            // addAll (Collection) : 다른 컬렉션의 원소를 전부 추가
            // 컬렉션 - (List, Set, PriorityQueue, ArrayDeque 모두 가능)

            int sizeCount = 0;
            while (k > 0) {
                k -= pq.poll(); // 누적 합(totalCount) 대신 남은 양을 제해 나가기
                sizeCount++;
            }
            return sizeCount;
        }
    }
}
