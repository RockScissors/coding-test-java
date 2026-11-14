package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
    public static class MySolution {
        public int[] solution(int n, String[] words) {
            Set<String> bWords = new HashSet<>();

            int turn = 1;
            int loser = -1;
            char prevLastChar = '.';
            for (int i = 0; i < words.length; i++) {
                String currWord = words[i];
                turn = i / n + 1;
                loser = i % n + 1;
                if (i > 0 && (currWord.charAt(0) != prevLastChar
                        || bWords.contains(currWord))) {
                    return new int[]{loser, turn};
                }
                prevLastChar = currWord.charAt(currWord.length() - 1);
                bWords.add(currWord);
            }
            return new int[]{0, 0};
        }
    }

    // 첫 단어는 비교할 단어도 중복 단어도 없음 -> 검사 제외
    // turn, loser는 따로 변수로 둘 필요 X, 필요한 경우 계산하면 됨
    // 이전 단어는 words[i - 1]로 바로 접근 가능, prevLastChar 변수도 불필요

    public static class OptimalSolution {
        public int[] solution(int n, String[] words) {
            Set<String> used = new HashSet<>();
            used.add(words[0]);

            for (int i = 1; i < words.length; i++) {
                String prev = words[i - 1];
                String curr = words[i];
                if (prev.charAt(prev.length() - 1) != curr.charAt(0)
                        || !used.add(curr)) {
                    // Set.add()는 삽입 성공 시 true, 실패 시 false 반환
                    return new int[]{i % n + 1, i / n + 1};
                }
            }
            return new int[]{0, 0};
        }
    }
}
