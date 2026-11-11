package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
    public static class MySolution {
        public boolean solution(String[] phone_book) {
            // 번호를 Set에 넣고, 각 번호마다 자기보다 짧은 앞부분이 Set에 있는지 확인
            Set<String> pNums = new HashSet<>();
            int minLen = Integer.MAX_VALUE;
            int maxLen = Integer.MIN_VALUE;
            for (String s : phone_book) {
                int len = s.length();
                if (len < minLen) minLen = len;
                if (len > maxLen) maxLen = len;
                pNums.add(s);
            }
            for (String s : phone_book) {
                for (int i = minLen; i < Math.min(maxLen, s.length()); i++) {
                    String part = s.substring(0, i);
                    if (pNums.contains(part)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    // maxLen의 존재 불필요
    // 변수명 part -> prefix이 더 명시적
    // substring이 번호당 최대 19개의 새 String 생성

    public static class OptimalSolution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book); // 사전순 : 접두어가 바로 다음 칸에 붙음
            // 사전순 정렬 - 1, 12, 123, 2, ...
            for (int i = 0; i < phone_book.length - 1; i++) {
                // A가 B의 접두어면 A < B, 사전순으로 그 사이 번호는 전부 A로 시작
                // -> A 바로 다음 번호도 A로 시작 -> 앞뒤(이웃)만 비교하면 됨
                // substring으로 새 String을 안 만들어서 객체 부담이 적음
                if (phone_book[i + 1].startsWith(phone_book[i])) return false;
            }
            return true;
        }
    }
}
