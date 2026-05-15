package programmers.level1;

public class 옹알이 {
    public static class MySolution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] speak = {"aya", "ye", "woo", "ma"};
            String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};

            for (String s : babbling) {
                if (s.contains(repeat[0]) || s.contains(repeat[1]) || s.contains(repeat[2])  || s.contains(repeat[3])) continue;

                for (String sp : speak) {
                    s = s.replace(sp, " ");
                }

                s = s.replace(" ", "");
                if (s.isEmpty()) answer++;
            }

            return answer;
        }
    }
}
