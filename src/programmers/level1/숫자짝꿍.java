package programmers.level1;

public class 숫자짝꿍 {

    public static class MySolution {
        public String solution(String X, String Y) {
            int[] numbersX = new int[10];
            int[] numbersY = new int[10];

            for(int i = 0; i < X.length(); i++) {
                numbersX[X.charAt(i) - '0']++;
            }
            for(int i = 0; i < Y.length(); i++) {
                numbersY[Y.charAt(i) - '0']++;
            }

            StringBuilder sb = new StringBuilder();

            boolean isZero = true;
            for(int i = 9; i >= 0; i--) {
                int count = Math.min(numbersX[i], numbersY[i]);
                String s = String.valueOf(i).repeat(count);
                sb.append(s);
                if (i != 0 && count != 0) isZero = false;
            }

            String answer = sb.toString();
            if (answer.equals("")) return "-1";
            if (isZero) return "0";

            return answer;
        }
    }

}
