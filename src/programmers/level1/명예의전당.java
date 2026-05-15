package programmers.level1;

public class 명예의전당 {
    public static class MySolution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            int[] hallOfFame = new int[k];
            int minIndex = 0;

            for(int i = 0; i < score.length; i++){
                if (i < k) {
                    hallOfFame[i] = score[i];
                    minIndex = hallOfFame[i] < hallOfFame[minIndex]? i : minIndex;
                }
                else {
                    if (hallOfFame[minIndex] < score[i]) {
                        hallOfFame[minIndex] = score[i];
                        minIndex = getMinIndex(hallOfFame);
                    }

                }
                answer[i] = hallOfFame[minIndex];
            }
            return answer;
        }

        private int getMinIndex(int[] arr){
            int idx = 0;
            int min = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    idx = i;
                }
            }
            return idx;
        }
    }
}
