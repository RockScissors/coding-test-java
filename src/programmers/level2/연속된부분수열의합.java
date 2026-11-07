package programmers.level2;

public class 연속된부분수열의합 {
    public static class MySolution {
        public int[] solution(int[] sequence, int k) {
            int len = sequence.length;
            int[] idx = {0, Integer.MAX_VALUE};

            int start = 0, end = 0, sum = sequence[0];
            while (start <= end && end < len) {
                if (sum < k) {
                    if (end == len - 1) break;
                    sum += sequence[++end];
                } else {
                    int minSeqLen = idx[1] - idx[0];
                    int seqLen = end - start;
                    if (sum == k && seqLen < minSeqLen) {
                        idx[0] = start;
                        idx[1] = end;
                    }
                    sum -= sequence[start++];
                }
            }

            return idx;
        }
    }

    public static class OptimalSolution {
        public int[] solution(int[] sequence, int k) {
            int[] answer = new int[2];
            int start = 0, sum = 0, bestLen = Integer.MAX_VALUE;

            for (int end = 0; end < sequence.length; end++) {
                sum += sequence[end];                  // 1. 새 원소를 넣고
                while (sum > k) sum -= sequence[start++];   // 2. 넘치면 앞에서 빼고
                if (sum == k && end - start < bestLen) {    // 3. 같으면 기록
                    bestLen = end - start;
                    answer = new int[]{start, end};
                }
            }
            return answer;
        }
    }
}
