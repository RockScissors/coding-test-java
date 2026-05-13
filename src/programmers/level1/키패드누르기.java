package programmers.level1;
import java.util.*;

public class 키패드누르기 {

    public static class MySolution {

        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
            String[] dir = {"L", "R"};
            int[] currentPosition = {10, 12};

            for (int n : numbers) {
                int idx = -1;
                n = (n == 0) ? 11 : n;

                if (n == 1 || n == 4 || n == 7) idx = 0;
                else if (n == 3 || n == 6 || n == 9) idx = 1;
                else {
                    int distanceL = calculateDistance(currentPosition[0], n);
                    int distanceR = calculateDistance(currentPosition[1], n);

                    if (distanceL == distanceR)
                        idx = hand.equals("left") ? 0 : 1;
                    else
                        idx = distanceL < distanceR ? 0 : 1;
                }

                sb.append(dir[idx]);
                currentPosition[idx] = n;
            }

            return sb.toString();
        }

        private int calculateDistance(int from, int to) {
            int diff = Math.abs(from - to);
            int floorDiff = (diff + 1) / 3;
            int leftRightDiff = (diff % 3 == 0) ? 0 : 1;
            return floorDiff + leftRightDiff;
        }
    }

    // 2차원 배열, 좌표 변환, 맨해튼 거리
    // 격자무늬 이동 거리는 X, Y 좌표로 변환
    // X = (N - 1) % (열의 개수), Y = (N - 1) / (열의 개수)
    // 맨해튼 거리 공식: |X1 - X2| + |Y1 + Y2|
    public static class OptimalSolution {

        public String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();
            String[] dir = {"L", "R"};
            int[] currentPosition = {10, 12};

            for (int n : numbers) {
                int idx = -1;
                n = (n == 0) ? 11 : n;

                if (n == 1 || n == 4 || n == 7) idx = 0;
                else if (n == 3 || n == 6 || n == 9) idx = 1;
                else {
                    int distanceL = calculateDistance(currentPosition[0], n);
                    int distanceR = calculateDistance(currentPosition[1], n);

                    if (distanceL == distanceR)
                        idx = hand.equals("left") ? 0 : 1;
                    else
                        idx = distanceL < distanceR ? 0 : 1;
                }

                sb.append(dir[idx]);
                currentPosition[idx] = n;
            }

            return sb.toString();
        }

        private int calculateDistance(int from, int to) {
            int fromX = (from - 1) % 3;
            int fromY = (from - 1) / 3;

            int toX = (to - 1) % 3;
            int toY = (to - 1) / 3;

            return Math.abs(fromX - toX) + Math.abs(fromY - toY);
        }
    }
}