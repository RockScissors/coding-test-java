package programmers.level2;

public class 다음큰숫자 {
    public static class MySolution {
        public int solution(int n) {
            int answer = n;
            int nCountOne = countOne(toBinary(n));
            // 하나하나 수를 늘려가며 이진표현의 1 개수 비교
            // 정확성 테스트 성공, 효율성 테스트 실패
            while (true) {
                String binaryAnswer = toBinary(++answer);
                if (nCountOne == countOne(binaryAnswer)) {
                    break;
                }
            }
            return answer;
        }
        private String toBinary(int num) {
            String binary = "";
            while (num > 0) {
                binary = String.valueOf(num % 2) + binary;
                num /= 2;
            }
            return binary;
        }
        private int countOne(String num) {
            int count = 0;
            for (char c : num.toCharArray()) {
                if (c == '1') count++;
            }
            return count;
        }
    }

    // Integer.toBinaryString(int) -> 정수를 2진수 문자열로 변환
    // Integer.bitCount(int) -> 정수의 이진수에서 1 개수 반환

    public static class OptimalSolution {
        public int solution(int n) {
            int answer = n;
            int nCountOne = countOne(Integer.toBinaryString(n));
            while (true) {
                String binaryAnswer = Integer.toBinaryString(++answer);
                if (nCountOne == countOne(binaryAnswer)) {
                    break;
                }
            }
            return answer;
        }
        private int countOne(String num) {
            int count = 0;
            for (char c : num.toCharArray()) {
                if (c == '1') count++;
            }
            return count;
        }
    }

    public static class OptimalSolution2 {
        public int solution(int n) {
            int ones = Integer.bitCount(n);
            int answer = n + 1;
            while (Integer.bitCount(answer) == ones) answer++;
            return answer;
        }
    }
}
