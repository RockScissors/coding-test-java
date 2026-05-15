package programmers.level1;

public class 서울에서김서방찾기 {
    public static class MySolution {
        public String solution(String[] seoul) {
            int answer = 0;

            for (String s : seoul) {
                if (s.equals("Kim")) break;
                answer++;
            }

            return "김서방은 " + answer + "에 있다";
        }
    }
}
