package programmers.level1;

public class 부족한금액계산하기 {
    public static class MySolution {
        public long solution(int price, int money, int count) {
            long answer = money - ((long) count * (count + 1) * price / 2);
            return answer >= 0? 0 : -answer;
        }
    }
}
