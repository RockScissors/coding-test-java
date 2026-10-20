package programmers.level1;


public class 지폐접기 {
    public static class MySolution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;

            int walletMax = Math.max(wallet[0], wallet[1]);
            int walletMin = Math.min(wallet[0], wallet[1]);

            while (true) {
                int billMax = Math.max(bill[0], bill[1]);
                int billMin = Math.min(bill[0], bill[1]);
                if (walletMax < billMax || walletMin < billMin) {
                    if (bill[0] > bill[1]) bill[0] = (int)(bill[0] / 2);
                    else if (bill[1] >= bill[0]) bill[1] = (int)(bill[1] / 2);
                    answer++;
                    continue;
                }
                break;
            }

            return answer;
        }
    }

    // 긴 쪽 / 짧은 쪽으로 정규화하면 회전 비교가 필요 X
    // 긴 것은 긴 것끼리, 짧은 것은 짧은 것끼리만 비교하면 됨

    // while(true){if(조건)} -> while(조건){}
    // int끼리 수행한 나눗셈은 캐스팅 없이도 정수 몫

    public static class OptimalSolution {
        public int solution(int[] wallet, int[] bill) {
            int wMax = Math.max(wallet[0], wallet[1]);
            int wMin = Math.min(wallet[0], wallet[1]);
            int bMax = Math.max(bill[0], bill[1]);
            int bMin = Math.min(bill[0], bill[1]);

            int answer = 0;
            while (bMax > wMax || bMin > wMin) {
                bMax /= 2;              // 긴 쪽을 반으로 접는다
                answer++;
                int big = Math.max(bMax, bMin);   // 접은 뒤 다시 정규화
                bMin = Math.min(bMax, bMin);
                bMax = big;
            }
            return answer;
        }
    }
}
