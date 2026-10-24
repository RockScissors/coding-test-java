package programmers.level1;

public class 이웃한칸 {
    public static class MySolution {
        public int solution(String[][] board, int h, int w) {
            int answer = 0;
            int[] checkHPosition = {-1, 1, 0, 0};
            int[] checkWPosition = {0, 0, -1, 1};
            String color = board[h][w];

            for (int i = 0; i < 4; i++) {
                int currentH = h + checkHPosition[i];
                int currentW = w + checkWPosition[i];

                if (currentH < 0 || currentH >= board.length || currentW < 0 || currentW >= board[0].length) continue;

                answer = (color.equals(board[currentH][currentW]))? answer + 1 : answer;
            }

            return answer;
        }
    }
}
