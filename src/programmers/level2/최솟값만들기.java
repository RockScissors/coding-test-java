package programmers.level2;

import java.util.Arrays;

public class 최솟값만들기 {
    public static class MySolution {
        public int solution(int []A, int []B)
        {
            int answer = 0;
            A = Arrays.stream(A).sorted().toArray();
            B = Arrays.stream(B).sorted().toArray();
            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[B.length - i - 1];
            }
            return answer;
        }
    }

    // IntStream과 Stream<Integer>는 다른 타입
    // Arrays.stream(int[]) -> IntStream, Arrays.stream(int[]).toArray() -> 동일 배열
    // IntStream -> List<Integer> , .boxed.toList()
    // List<Integer> -> int[] , list.stream().mapToInt(Integer::intValue).toArray()
    // String[] -> int[] , Arrays.stream(arr).mapToInt(Integer::parseInt).toArray()

    // Arrays.sort() - 제자리 정렬, 원본 바뀜 (일부만 - sort(a, from, to)
    // Arrays.copyOf(a, 길이) , Arrays.copyOfRange(a, from, to) - to 미포함

    public static class OptimalSolution {
        public int solution(int []A, int []B) {
            Arrays.sort(A);
            Arrays.sort(B);
            int answer = 0;
            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[B.length - 1 - i];
            }
            return answer;
        }
    }
}
