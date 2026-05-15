package programmers.level1;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {
    public static class MySolution {
        public long solution(long n) {
            long answer = 0;
            int digitNum = Long.toString(n).length();
            int[] digit = new int[digitNum];

            for(int i=0; n>0; i++) {
                digit[i] = (int)(n % 10);
                n = n / 10;
            }

            Arrays.sort(digit);

            long temp = 1L;
            for(int i=0; i<digitNum; i++){
                answer += digit[i] * temp;
                temp = temp * 10;
            }

            return answer;
        }
    }
}
