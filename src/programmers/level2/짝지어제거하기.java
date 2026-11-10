package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 짝지어제거하기 {
    public static class MySolution {
        public int solution(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }
            return stack.isEmpty()? 1 : 0;
        }
    }

    // 처음 시도 - String.replace로 짝을 지우고 다시 처음 인덱스부터 훑기
    // -> 효율성 테스트 실패

}
