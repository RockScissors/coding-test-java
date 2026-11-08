package programmers.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호 {
    public static class MySolution {
        boolean solution(String s) {
            int open = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') open++;
                else if (c == ')') open--;
                if (open < 0) return false;
            }

            return open == 0;
        }
    }

    // 괄호 종류가 여러 개가 된다면 스택 필요 ( (), [], {} )
    // '({)}'의 경우, 괄호의 종류와 닫히는 순서가 맞지 않아 예외
    // 닫는 괄호는 가장 최근에 열린 괄호와 짝이어야 함 -> 최근 열린 것을 기억해야 함
    // 스택(후입선출) : 열릴 때 push, 닫힐 때 top과 비교 후 pop

    // 스택 : push / pop / peek / isEmpty
    // 큐 : offer (또는 add) / poll / peek / isEmpty

    // poll, peek : 비었으면 null
    // pop, remove : 비었으면 예외

    public static class OptimalSolution {
        boolean solution(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(c);
                else {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
}
