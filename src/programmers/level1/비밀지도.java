package programmers.level1;


public class 비밀지도 {
    public static class MySolution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for(int i = 0; i < n; i++) {
                String arr1Binary = toBinary(n, arr1[i]);
                String arr2Binary = toBinary(n, arr2[i]);

                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if (arr1Binary.charAt(j) == '0' &&
                            arr2Binary.charAt(j) == '0')
                        sb.append(" ");
                    else
                        sb.append("#");
                }

                answer[i] = sb.toString();
            }

            return answer;
        }

        private String toBinary(int n, int num) {
            long binary = 0;
            long digit = 1;

            while (num != 0) {
                binary += (num % 2) * digit;
                digit *= 10;
                num /= 2;
            }

            String strBinary = String.valueOf(binary);

            return "0".repeat(n - strBinary.length()) + strBinary;
        }
    }

    // 내장 함수가 있다면 내장 함수 사용하기
    // 비트 연산자 사용하기
    // 조건의 자릿수 크기 (오버플로우 가능성) 항상 확인하기

    public static class OptimalSolution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for (int i = 0; i < n; i++) {
                String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
                binaryString = String.format("%" + n + "s", binaryString);
                answer[i] = binaryString.replaceAll("1", "#").replaceAll("0", " ");
            }

            return answer;
        }
    }
}
