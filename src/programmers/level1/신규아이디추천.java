package programmers.level1;


public class 신규아이디추천 {
    public static class MySolution {
        public String solution(String new_id) {

            // 1
            String answer = new_id.toLowerCase();

            // 2
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.length(); i++) {
                if ((answer.charAt(i) >= 'a'&& answer.charAt(i) <= 'z')
                        || (answer.charAt(i) >= '0' && answer.charAt(i) <= '9')
                        || answer.charAt(i) == '-'
                        || answer.charAt(i) == '_'
                        || answer.charAt(i) == '.') {
                    sb.append(answer.charAt(i));
                }
            }
            answer = sb.toString();

            // 3
            sb = new StringBuilder();
            int count = 0;
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == '.') {
                    count++;
                    if (count == 1) {
                        sb.append(answer.charAt(i));
                        continue;
                    }
                } else {
                    count = 0;
                    sb.append(answer.charAt(i));
                }
            }
            answer = sb.toString();

            // 4
            if (answer.length() == 1) {
                if (answer.charAt(0) == '.') answer = "";
            } else if (answer.length() > 1) {
                if (answer.charAt(0) == '.') {
                    answer = answer.substring(1, answer.length());
                }
                if (answer.charAt(answer.length() - 1) == '.') {
                    answer = answer.substring(0, answer.length() - 1);
                }
            }

            // 5
            if (answer.isBlank()) {
                answer = "a";
            }

            // 6
            if (answer.length() >= 16) {
                answer = answer.substring(0, 15);
                if (answer.charAt(14) == '.') {
                    answer = answer.substring(0, 14);
                }
            }

            // 7
            if (answer.length() < 3) {
                answer = answer + answer.substring(answer.length() - 1).repeat(3 - answer.length());
            }

            return answer;
        }
    }

    // substring(begin, end) -> [begin, end)
    // substring(begin) == substring(begin, length()) : 해당 인덱스부터 문자열 끝까지
    // 매직 넘버 : 의미가 코드에 드러나지 않는 숫자 리터럴
    // String.startsWith, String.endsWith
    // String.replace는 겹치지 않는 일치를 전부 한 번에 변경

    public static class OptimalSolution {
        private static final int MAX_LEN = 15;
        private static final int MIN_LEN = 3;

        public String solution(String new_id) {
            String id = new_id.toLowerCase();

            StringBuilder sb = new StringBuilder();
            for (char c : id.toCharArray()) {
                if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')
                || c == '-' || c == '_' || c =='.') {
                    sb.append(c);
                }
            }
            id = sb.toString();

            while (id.contains("..")) id = id.replace("..", ".");

            if (id.startsWith(".")) id = id.substring(1);
            if (id.endsWith(".")) id = id.substring(0, id.length() - 1);

            if (id.isEmpty()) id = "a";

            if (id.length() > MAX_LEN) {
                id = id.substring(0, MAX_LEN);
                if (id.endsWith(".")) id = id.substring(0, id.length() - 1);
            }

            while (id.length() < MIN_LEN) id += id.charAt(id.length() - 1);
            return id;
        }
    }
}
