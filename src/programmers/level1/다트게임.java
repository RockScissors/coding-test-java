package programmers.level1;

public class 다트게임 {
    public static class MySolution {
        public int solution(String dartResult) {
            int answer = 0;
            int score[] = new int[9];

            int idx = -1;
            int s = 0;
            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);

                if (c >= '0' && c <= '9') {
                    idx++;
                    if (c == '1' && dartResult.charAt(i + 1) == '0') {
                        s = 10;
                        i++;
                        continue;
                    }
                    s = c - '0';
                }
                else if (c == 'D') s = s * s;
                else if (c == 'T') s = s * s * s;
                else if (c == '*') {
                    s *= 2;
                    if (idx != 0) {
                        score[idx - 1] *= 2;
                    }
                }
                else if (c == '#') s *= -1;

                score[idx] = s;
            }

            for (int i : score) {
                answer += i;
            }

            return answer;
        }
    }


    public static class OptimalSolution {
        public int solution(String dartResult) {
            int[] score = new int[3];
            int count = 0;
            int num = 0;

            for (char c : dartResult.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                } else if (c == 'S' || c == 'D' || c == 'T') {
                    int value = num;
                    if (c == 'D') value = num * num;
                    else if (c == 'T') value = num * num * num;
                    score[count] = value;
                    count++;
                    num = 0;
                } else if (c == '*') {
                    score[count - 1] *= 2;
                    if (count >= 2) score[count - 2] *= 2;
                } else if (c == '#') {
                    score[count - 1] *= -1;
                }
            }

            int answer = 0;
            for (int s : score) answer += s;
            return answer;
        }
    }
}
