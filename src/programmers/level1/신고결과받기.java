package programmers.level1;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 신고결과받기 {
    public static class MySolution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, Set<String>> reportedByMap = new HashMap<>(); // 신고당한 사람 - 신고한 사람[]
            Map<String, Integer> emailCount = new HashMap<>();
            for (String id : id_list) {
                reportedByMap.put(id, new HashSet<>());
                emailCount.put(id, 0);
            }

            for (String r : report) { // 신고 횟수
                String[] parts = r.split(" ");
                reportedByMap.get(parts[1]).add(parts[0]);
            }

            for (String id : id_list) { // 이메일 횟수
                Set<String> reportedBy = reportedByMap.get(id);
                if (reportedBy.size() < k) continue;
                for (String user : reportedBy) {
                    emailCount.put(user, emailCount.getOrDefault(user, 0) + 1);
                }
            }

            int[] answer = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++) {
                answer[i] = emailCount.getOrDefault(id_list[i], 0);
            }

            return answer;
        }
    }

    // map.computeIfAbsent(k, key -> new HashSet<>()) 없을 때만 새로 만들어 줆

    // getOrDefault 중복 작성 불필요

    // map.merge(key, value, 합치는 법)
    // 키가 없으면 put(key, value), 키가 있으면 put(key, 합치는 방법(기존값, value))
    // Integer::Sum -> 기존값과 새 값을 더함

    public static class OptimalSolution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, Set<String>> reportersByTarget = new HashMap<>(); // 신고당한 사람 → 신고한 사람들
            Map<String, Integer> mailCount = new HashMap<>(); // 신고한 사람 -> 받은 메일 수

            for (String r : report) {
                String[] parts = r.split(" ");
                reportersByTarget.computeIfAbsent(
                        parts[1], key -> new HashSet<>()).add(parts[0]
                );
            }
            for (Set<String> reporters : reportersByTarget.values()) {
                if (reporters.size() < k) continue;
                for (String reporter : reporters) {
                    mailCount.merge(reporter, 1, Integer::sum); // 이거 머임??
                }
            }

            int[] answer = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++) {
                answer[i] = mailCount.getOrDefault(id_list[i], 0);
            }
            return answer;
            // 한 줄로 쓴다면
            // return Arrays.stream(id_list)
            // .mapToInt(id -> mailCount.getOrDefault(id, 0)).toArray();
        }
    }
}
