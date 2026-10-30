package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 개인정보수집유효기간 {
    public static class MySolution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> termsMap = new HashMap<>();
            for (String term : terms) {
                String[] termArr = term.split(" ");
                termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
            }

            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < privacies.length; i++) {
                String[] privacyArr = privacies[i].split(" ");
                int term = termsMap.get(privacyArr[1]);
                if (validatePassed(today, privacyArr[0], term)) {
                    resultList.add(i);
                }
            }

            int[] answer = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                answer[i] = resultList.get(i) + 1;
            }
            return answer;
        }

        private boolean validatePassed(
                String today, String collectedDate, int term
        ) {
            String[] todayYTD = today.split("\\.");
            String[] collectedDateYTD = collectedDate.split("\\.");

            int tdd = Integer.parseInt(todayYTD[0]) * 12 * 28 + Integer.parseInt(todayYTD[1]) * 28 + Integer.parseInt(todayYTD[2]);
            int cdd = Integer.parseInt(collectedDateYTD[0]) * 12 * 28 + Integer.parseInt(collectedDateYTD[1]) * 28 + Integer.parseInt(collectedDateYTD[2]);

            return tdd >= cdd + term * 28;
        }
    }

    // String.split()의 인자는 정규식
    // '.' -> 아무 글자 하나, '\\.' or '[.]'로 작성

    // 날짜 파싱 중복 -> toDays() 한 곳에서 변환

    // List<Integer>.stream()은 Stream<Integer> (제네릭 안에 프리미티브 X)
    // mapToInt로 IntStream으로 갈아타야 toArray()가 int[]
    // Arrays.stream(int[])는 처음부터 IntStream -> mapToInt 불필요
    // +) 스트림 - 중간 연산은 계획만 등록(지연 평가), toArray() 같은 최종 연산에서 실제 실행

    public static class OptimalSolution {
        private static final int DAYS_PER_MONTH = 28;
        private static final int DAYS_PER_YEAR = 12 * DAYS_PER_MONTH;

        public int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> termMonths = new HashMap<>();
            for (String term : terms) {
                String[] parts = term.split(" ");
                termMonths.put(parts[0], Integer.parseInt(parts[1]));
            }

            int todayDays = toDays(today);
            List<Integer> expiredNumbers = new ArrayList<>();
            for (int i = 0; i < privacies.length; i++) {
                String[] parts = privacies[i].split(" ");
                int months = termMonths.get(parts[1]);
                if (todayDays >= toDays(parts[0]) + months * DAYS_PER_MONTH) {
                    expiredNumbers.add(i + 1);
                }
            }

            return expiredNumbers.stream().mapToInt(Integer::intValue).toArray();
        }

        private int toDays(String date) {
            String[] parts = date.split("\\.");
            return Integer.parseInt(parts[0]) * DAYS_PER_YEAR
                    + Integer.parseInt(parts[1]) * DAYS_PER_MONTH
                    + Integer.parseInt(parts[2]);
        }
    }
}