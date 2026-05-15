package programmers.level1;

import java.util.Stack;

public class 햄버거만들기 {

    public static class MySolution {
        public int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> stack = new Stack<>();

            for (int i : ingredient) {
                stack.push(i);

                if (stack.peek() == 1 && stack.size() >= 4) {
                    if (stack.get(stack.size() - 2) == 3) {
                        if (stack.get(stack.size() - 3) == 2) {
                            if (stack.get(stack.size() - 4) == 1) {
                                for (int j = 0; j < 4; j++) {
                                    stack.pop();
                                }
                                answer++;
                            }
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static class OptimalSolution {
        public int solution(int[] ingredient) {
            int answer = 0;

            int[] stack = new int[ingredient.length];
            int top = 0;

            for (int item : ingredient) {
                stack[top++] = item;

                if (top >= 4 &&
                   stack[top - 4] == 1 &&
                   stack[top - 3] == 2 &&
                   stack[top - 2] == 3 &&
                   stack[top - 1] == 1) {

                    top -= 4;
                    answer++;
                }
            }

            return answer;
        }
    }
}
