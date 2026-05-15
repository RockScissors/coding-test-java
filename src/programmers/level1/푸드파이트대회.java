package programmers.level1;

public class 푸드파이트대회 {
    public static class MySolution {
        public String solution(int[] food) {
            StringBuilder sb = new StringBuilder();

            for(int i = 1; i < food.length; i++) {
                int num = food[i] / 2;
                for(int j = 0; j < num; j++){
                    sb.append(String.valueOf(i));
                }
            }
            String reverse = new StringBuilder(sb).reverse().toString();
            sb.append(0 + reverse);
            return sb.toString();
        }
    }
}
