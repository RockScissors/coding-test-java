package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
    public static class MySolution {
        public String[] solution(String[] players, String[] callings) {
            Map<String, Integer> rankings = new HashMap<>();

            for (int i = 0; i < players.length; i++) {
                rankings.put(players[i], i);
            }

            for (String s : callings) {
                int currentRank = rankings.get(s);
                String frontRunner = players[currentRank - 1];

                players[currentRank] = frontRunner;
                players[currentRank - 1] = s;

                rankings.put(s, currentRank - 1);
                rankings.put(frontRunner, currentRank);
            }

            return players;
        }
    }
}
