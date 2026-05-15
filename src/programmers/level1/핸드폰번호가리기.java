package programmers.level1;

public class 핸드폰번호가리기 {
    public static class MySolution {
        public String solution(String phone_number) {
            char[] answer = phone_number.toCharArray();

            for (int i = phone_number.length() - 5; i >= 0; i--) {
                answer[i] = '*';
            }

            return String.valueOf(answer);
        }
    }
}
