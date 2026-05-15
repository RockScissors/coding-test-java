package programmers.level1;

public class 가운데글자가져오기 {
    public static class MySolution {
        public String solution(String s) {
            int mid = s.length() / 2;
            return s.length() % 2 == 0
                    ? s.substring(mid - 1, mid + 1)
                    : s.substring(mid, mid + 1);
        }
    }
}
