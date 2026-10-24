package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 공원산책 {
    public static class MySolution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            Map<String, int[]> cardinal = Map.of(
                    "N", new int[]{-1, 0},
                    "S", new int[]{1, 0},
                    "W", new int[]{0, -1},
                    "E", new int[]{0, 1}

            );

            // 시작 지점 찾기
            outer:
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[i].length(); j++) {
                    if (park[i].charAt(j) == 'S') {
                        answer[0] = i;
                        answer[1] = j;
                        break outer;
                    }
                }
            }

            // 산책
            outer:
            for (String r : routes) {
                String d = String.valueOf(r.charAt(0));
                int l = Integer.valueOf(String.valueOf(r.charAt(2)));

                int nx = answer[1];
                int ny = answer[0];

                for (int i = 0; i < l; i++) {
                    nx += cardinal.get(d)[1];
                    ny += cardinal.get(d)[0];

                    if (ny < 0
                            || ny >= park.length
                            || nx < 0
                            || nx >= park[0].length()
                            || park[ny].charAt(nx) == 'X') {
                        continue outer;
                    }
                }

                answer[0] = ny;
                answer[1] = nx;
            }

            return answer;
        }
    }

    // Integer.valueOf(String.valueOf(r.charAt(2))) 는 장황함
    // Integer.parseInt(r.substring(2)) or r.charAt(2) - '0'

    // 변수명 l -> dist
    // 방향 처리는 dx/dy 배열 + indexOf로

    public static class OptimalSolution {
        public int[] solution(String[] park, String[] routes) {
            int h = park.length, w = park[0].length();
            int y = 0, x = 0;

            // 시작 지점 탐색
            for (int i = 0; i < h; i++) {
                int j = park[i].indexOf('S');
                if (j != -1) { y = i; x = j; break; }
            }

            int[] dy = {-1, 1, 0, 0};   // N S W E
            int[] dx = {0, 0, -1, 1};

            for (String route : routes) {
                int k = "NSWE".indexOf(route.charAt(0));
                int dist = route.charAt(2) - '0';

                int ny = y, nx = x;
                boolean ok = true;
                for (int s = 0; s < dist; s++) {
                    ny += dy[k];
                    nx += dx[k];
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w || park[ny].charAt(nx) == 'X') {
                        ok = false;
                        break;
                    }
                }
                if (ok) { y = ny; x = nx; }
            }
            return new int[]{y, x};
        }
    }
}
