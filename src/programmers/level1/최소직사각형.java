package programmers.level1;

public class 최소직사각형 {
    public static class MySolution {
        public int solution(int[][] sizes) {
            int maxHeight = 0;
            int maxWidth = 0;

            int height, width;
            // 길이가 긴 부분들 하나로 몰아넣기 -> 길이 긴 게 가로
            for (int i = 0; i < sizes.length; i++) {
                width = (sizes[i][0] > sizes[i][1])
                        ? sizes[i][0] : sizes[i][1];
                height = (sizes[i][0] > sizes[i][1])
                        ? sizes[i][1] : sizes[i][0];

                if (width > maxWidth) maxWidth = width;
                if (height > maxHeight) maxHeight = height;
            }

            return maxHeight * maxWidth;
        }
    }
}
