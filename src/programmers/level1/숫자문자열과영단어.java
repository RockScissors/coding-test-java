package programmers.level1;

public class 숫자문자열과영단어 {
    public static class MySolution {
        public int solution(String s) {
            String[] numbers = {"zero", "one", "two", "three", "four",
                    "five", "six", "seven", "eight", "nine"};

            for(int i = 0; i < numbers.length; i++) {
                s = s.replace(numbers[i], String.valueOf(i));
            }

            return Integer.parseInt(s);
        }
    }
}
