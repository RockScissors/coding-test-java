package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class 로또의최고순위와최저순위 {
    public static class MySolution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int hiddenNumCount = 0;
            int sameNumCount = 0;

            Set<Integer> set = new HashSet<>();

            for (int i : win_nums) {
                set.add(i);
            }

            for (int i : lottos) {
                if (i == 0) hiddenNumCount++;
                if (set.remove(i)) sameNumCount++;
            }

            int highestRank = (sameNumCount + hiddenNumCount) == 0? 6 : 7 - (sameNumCount + hiddenNumCount);
            int lowestRank = sameNumCount == 0? 6 : 7 - sameNumCount;
            int[] answer = {highestRank, lowestRank};

            return answer;
        }
    }

    // 변수명 개선 (int i -> int num, sameNumCount -> match)
    // [맞힌 개수]를 인덱스로 삼는 등수 표 미리 생성
    // (순위표 배열 미리 상수로 작성)

    public static class OptimalSolution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] rankTable = {6, 6, 5, 4, 3, 2, 1};

            Set<Integer> winSet = new HashSet<>();
            for (int num : win_nums) {
                winSet.add(num);
            }

            int match = 0;
            int hidden = 0;

            for (int num : lottos) {
                if (num == 0) {
                    hidden++;
                } else if (winSet.contains(num)) {
                    match++;
                }
            }

            // 생성하고 바로 return하는 문법
            return new int[]{rankTable[match + hidden], rankTable[match]};
        }
    }
}
