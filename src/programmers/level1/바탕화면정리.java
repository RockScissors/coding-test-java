package programmers.level1;

public class 바탕화면정리 {
    public static class MySolution {
        public int[] solution(String[] wallpaper) {
            int h = wallpaper.length;
            int w = wallpaper[0].length();

            int lux = h, luy = w; // 최댓값으로 초기화
            int rdx = 0, rdy = 0; // 최솟값으로 초기화

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    char c = wallpaper[i].charAt(j);
                    if (c == '#') {
                        if (luy > j) luy = j;
                        if (lux > i) lux = i;
                        if (rdy < j) rdy = j;
                        if (rdx < i) rdx = i;
                    }
                }
            }

            return new int[]{lux, luy, rdx + 1, rdy + 1};
        }
    }

    // Math.min(lux, i) 사용하면 간결화 가능
    // 칸과 격자점 -> 예: 칸 2는 눈금 2와 3 사이 존재, 칸 2를 포함하기 위해서는
    // 끝점은 눈금 3. 문제 꼼꼼하게 읽기
    // 변수명 : 격자에서는 row, col이 더 명확

}
