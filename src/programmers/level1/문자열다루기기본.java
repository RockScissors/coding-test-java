package programmers.level1;

public class 문자열다루기기본 {
    public static class MySolution {
        public boolean solution(String s) {
            char[] arr = s.toCharArray();
            if (!(arr.length == 4 || arr.length == 6)) return false;
            for (char c : arr) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }
    }
}
