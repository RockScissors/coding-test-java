package programmers.level1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 체육복 {
    public static class MySolution {
        public int solution(int n, int[] lost, int[] reserve) {
            Set<Integer> lostSet = new HashSet<>();
            Set<Integer> reserveSet = new HashSet<>();

            for (int l : lost) {
                lostSet.add(l);
            }
            for (int r : reserve) {
                if (lostSet.remove(r)) continue;
                reserveSet.add(r);
            }

            Iterator<Integer> it = lostSet.iterator();
            while (it.hasNext()) {
                Integer i = it.next();

                if (reserveSet.remove(i - 1)) {
                    it.remove();
                    continue;
                }
                if (reserveSet.remove(i + 1)) {
                    it.remove();
                    continue;
                }
            }


            return n - lostSet.size();
        }
    }

    // Set이라 데이터 순서 보장 X 문제
    // Iterator 보다는 lostSet.removeIf(r -> reserveSet.contains(r))

    public static class OptimalSolution {
        public int solution(int n, int[] lost, int[] reserve) {
            // 1. 전체 학생의 체육복 상태를 기록할 출석부 배열 (0번 인덱스는 안 쓰고, 패딩을 위해 n+2 크기로 만듦)
            int[] student = new int[n + 2];

            // 2. 도난당한 학생은 옷 개수 -1
            for (int l : lost) {
                student[l]--;
            }

            // 3. 여벌 가져온 학생은 옷 개수 +1
            // (본인이 도난당했어도 여기서 +1 되면 결국 0(정상)이 되므로 교집합이 자동 해결됨!)
            for (int r : reserve) {
                student[r]++;
            }

            // 4. 앞번호부터 순서대로 돌면서 빌려주기 (Greedy)
            for (int i = 1; i <= n; i++) {
                // 내가 체육복이 없다면(-1)
                if (student[i] == -1) {
                    // 앞번호가 여벌이 있는지 먼저 확인
                    if (student[i - 1] == 1) {
                        student[i]++;
                        student[i - 1]--;
                    }
                    // 앞번호가 없으면 뒷번호 확인
                    else if (student[i + 1] == 1) {
                        student[i]++;
                        student[i + 1]--;
                    }
                }
            }

            // 5. 옷이 0개 이상인(수업 들을 수 있는) 학생 수 카운트
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (student[i] >= 0) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
