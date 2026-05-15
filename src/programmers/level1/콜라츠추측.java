package programmers.level1;

public class 콜라츠추측 {
    public static class MySolution {
        public int solution(int num) {
            if (num == 1) return 0;

            long longNum = num;
            for (int i = 1; i <= 500; i++) {
                longNum = longNum % 2 == 0
                        ? longNum / 2 : longNum * 3 + 1;
                if (longNum == 1) return i;
            }

            return -1;
        }
    }
}

