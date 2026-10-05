import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }

        int[] tempArr = new int[2 * n];
        // 삽입
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                tempArr[i] = top[i];
            } else {
                tempArr[i] = bottom[i - n];
            }
        }

        // 밀기
        int[] resultArr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            int nextIdx = (i + t) % (2 * n);
            resultArr[nextIdx] = tempArr[i];
        }

        // 출력
        for (int i = 0; i < resultArr.length; i++) {
            if (i == n) System.out.println();
            System.out.print(resultArr[i] + " ");
        }

    }
}