package programmers.level1;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 크레인인형뽑기게임 {
    public static class MySolution {
        public int solution(int[][] board, int[] moves) {
            int poppedToyCount = 0;
            List<Integer> basket = new ArrayList<>();

            // toyCounts[] : 열마다 쌓여 있는 인형의 수
            int[] toyCounts = new int[board[0].length];
            for (int col = 0; col < board[0].length; col++) {
                int toyCount = 0;
                for (int row = board.length - 1; row >= 0; row--) {
                    if (board[row][col] == 0) break;
                    toyCount++;
                }
                toyCounts[col] = toyCount;
            }

            for (int i = 0; i < moves.length; i++) {
                int move = moves[i] - 1;
                int toyCount = toyCounts[move]; // 해당 열에 쌓인 인형 수

                if (toyCount == 0) continue;

                int rowIdx = board.length - toyCount;
                basket.add(board[rowIdx][move]);
                board[rowIdx][move] = 0;
                toyCounts[move]--;

                // 연속 두 개가 같은 인형이면 pop
                int num = basket.size() - 1;
                if (num > 0 && basket.get(num - 1) == basket.get(num)) {
                    basket.remove(num);
                    basket.remove(num - 1);
                    poppedToyCount += 2;
                }
            }

            return poppedToyCount;
        }
    }

    // Integer 비교는 equals로 (현재 캐시된 범위, -128~127 라서 우연히 일치)
    // Deque 스택 사용
    // 문제 제한에서 최악은 30 * 1000 = 3만 번
    // 1초에 1억 번 어림으로 잡기, 3만 번은 크지 않은 입력이라 굳이 따로 미리 센 포인터를 둘 필요 X
    // 반면 매번 값을 갱신하고 일치시키는 비용은 큼, 경우 판단하기

    public static class OptimalSolution {
        public int solution(int[][] board, int[] moves) {
            Deque<Integer> basket = new ArrayDeque<>();
            int popped = 0;

            for (int move : moves) {
                int col = move - 1;
                for (int row = 0; row < board.length; row++) {
                    int doll = board[row][col];
                    if (doll == 0) continue;

                    board[row][col] = 0;
                    if (!basket.isEmpty() && basket.peekLast() == doll) {
                        basket.pollLast();
                        popped += 2;
                    } else {
                        basket.addLast(doll);
                    }
                    break;
                }
            }
            return popped;
        }
    }
}
