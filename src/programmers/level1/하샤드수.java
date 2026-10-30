package programmers.level1;

public class 하샤드수 {
    public static class MySolution {
        public boolean solution(int x) {
            String strX = Integer.toString(x);
            char[] charArr = strX.toCharArray();
            int sum = 0;
            for(char c : charArr) {
                sum += Integer.parseInt(String.valueOf(c));
            }
            return (x % sum == 0) ? true : false ;
        }
    }
}
