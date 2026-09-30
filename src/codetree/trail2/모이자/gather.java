import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        int minSum = Integer.MAX_VALUE;
        
        for (int i = 0 ; i < n; i++) {
            int sum = 0;

            for (int j = 0; j < n; j++) {
                sum += Math.abs(j - i) * a[j];
                if (sum > minSum) break;
            }

            if (sum < minSum) minSum = sum;
        }

        System.out.println(minSum);
    }
}