package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static class MySolution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int n : nums) {
                set.add(Integer.valueOf(n));
            }

            return set.size() < nums.length / 2?
                    set.size() : nums.length/ 2;
        }
    }
}
