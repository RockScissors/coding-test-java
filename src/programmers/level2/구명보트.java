package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 구명보트 {
    public static class MyFirstSolution {
        public int solution(int[] people, int limit) {
            // 처음 시도
            // 정렬 -> 합이 가장 100에 가까운 조합부터 내보내기
            // 가장 무거운 사람 + 같이 탈 수 있는 사람 중 가장 무거운 사람
            // 매번 매 보트마다 앞에서부터 다시 훑어서 짝 찾음
            // 정확도 테스트 성공, 효율성 테스트에서 실패
            List<Integer> pList = new LinkedList<>();
            for (int p : people) {
                pList.add(p);
            }
            pList.sort((a, b) -> a - b);

            int count = 0;
            for (int i = pList.size() - 1; i >= 0; i--) {
                if (pList.size() == 1) {
                    count++; break;
                }
                int addIdx = -1;
                for (int j = 0; j < i; j++) {
                    if (pList.get(i) + pList.get(j) > limit) break;
                    addIdx = j;
                }
                if (addIdx != -1) {
                    pList.remove(addIdx);
                    i--;
                }
                pList.remove(i);
                count++;
            }

            return count;
        }
    }

    public static class MySolution {
        public int solution(int[] people, int limit) {
            // 정렬 -> 가장 무거운 사람 + 가장 가벼운 사람 짝 찾기
            // 가장 무거운 H가 가장 가벼운 L과 탈 수 없으면 -> 누구와도 탈 수 없음
            Arrays.sort(people);

            int light = 0; // 아직 타지 않은 사람 중 가장 가벼운 사람 위치
            int heavy = people.length - 1; // 아직 타지 않은 사람 중 가장 무거운 사람 위치
            int count = 0;
            while (heavy >= light) {
                if (people[heavy] >= limit) heavy--;
                else {
                    int weight = people[heavy] + people[light];
                    if (weight > limit) heavy--; // light와 같이 타면 초과 -> 혼자 탐
                    else { // 같이 탈 수 있음 -> 둘이 같이 타고 light++, heavy--
                        heavy--; light++;
                    }
                }
                count++; // 보트 출발
            }
            return count;
        }
    }

    // 중복되는 조건 정리
    public static class OptimalSolution {
        public int solution (int[] people, int limit) {
            Arrays.sort(people);
            int light = 0;
            int heavy = people.length - 1;
            int count = 0;
            while (light <= heavy) {
                if (people[light] + people[heavy] <= limit) light++;
                heavy--;
                count++;
            }
            return count;
        }
    }
}
