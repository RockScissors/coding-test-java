package programmers.level2;

import java.util.*;

public class 튜플 {
    public static class MySolution {
        public int[] solution(String s) {
            List<Set<Integer>> setList = new ArrayList<>();
            Set<Integer> set = new HashSet<>();

            char[] cArr = s.toCharArray();
            int es = 0; // 지금 읽는 숫자의 시작 위치
            // 바깥 '{'(index 0)와 마지막 '}'(length - 1)는 제외하고 읽기
            for (int i = 1; i < cArr.length - 1; i++) {
                char curr = cArr[i];
                if (curr == '{') { // 새 집합 시작
                    set = new HashSet<>();
                    setList.add(set);
                    es = i + 1; // 숫자는 '{' 다음부터
                }
                else if (curr == '}' || (cArr[i - 1] != '}' && curr == ',')) {
                    // 숫자 끝 : 집합 안의 ',' 또는 집합을 닫는 '}' (집합 사이의 ','는 제외)
                    set.add(Integer.valueOf(s.substring(es, i)));
                    // 통째로 잘라 변환 (ex 11이 1, 1로 쪼개지는 것 방지)
                    es = i + 1;
                }
            }

            // 원소가 적은 집합부터 정렬
            setList.sort((a, b) -> a.size() - b.size());

            int idx = 0;
            int[] answer = new int[setList.size()]; // 튜플 길이 = 집합 개수
            set = new HashSet<>();
            for (Set<Integer> ss : setList) {
                for (int i : ss) {
                    if (!set.contains(i)) { // 처음 보는 원소 = 다음 튜플 원소
                        answer[idx++] = i;
                        set.add(i);
                    }
                }
            }
            return answer;
        }
    }

    // String 메서드 : charAt O(1) , toCharArray O(n)
    // substring O(길이) , Integer.valueOf O(자릿수) , split O(n)

    // HashSet은 순서 보장 X / TreeSet은 정렬 / LinkedHashSet은 넣은 순서 유지
    // LinkedHashSet : 중복은 무시하고, 넣은 순서를 그대로 기억하는 Set

    public static class OptimalSolution {
        public int[] solution(String s) {
            // 바깥 "{{", "}}" 제거 -> "},{" 기준으로 집합 단위로 자르기
            // ex) "{{2},{2,1}}" -> "2},{2,1" -> ["2", "2,1"]
            String[] groups = s.substring(2, s.length() - 2).replace("},{", "/").split("/");
            // 짧은 문자열 = 원소가 적은 집합
            Arrays.sort(groups, (a, b) -> a.length() - b.length());

            Set<Integer> tuple = new LinkedHashSet<>(); // 중복 제거 + 넣은 순서 유지
            for (String group : groups) {
                for (String num : group.split(",")) { // 집합 안의 숫자들
                    tuple.add(Integer.parseInt(num)); // 이미 있으면 무시 -> 처음 보는 원소만 순서대로 쌓임
                }
            }
            return tuple.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
