package programmers.level1;

public class 제일작은수제거하기 {
    public static class MySolution {
        public int[] solution(int[] arr) {
            int[] answer;

            if (arr.length == 1) {
                answer = new int[1];
                answer[0] = -1;
                return answer;
            }

            answer = new int[arr.length - 1];
            int min = arr[0];
            int minIndex = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minIndex = i;
                }
            }

            // for (int i = 0; i < answer.length; i++) {
            //     answer[i] = (i < minIndex)
            //         ? arr[i]
            //         : arr[i + 1];
            // }
            System.arraycopy(arr, 0, answer, 0, minIndex);
            System.arraycopy(arr, minIndex + 1, answer, minIndex, answer.length - minIndex);

            return answer;
        }
    }
}
