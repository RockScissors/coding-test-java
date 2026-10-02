import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = 1;
            if (m == 1) {
                result++;
                continue;
            }

            for (int j = 1; j < n; j++) {
                if (grid[i][j - 1] != grid[i][j]) count = 0;
                count++;
                if (count == m) {
                    result++;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            if (m == 1) {
                result++;
                continue;
            }

            for (int j = 1; j < n; j++) {
                if (grid[j - 1][i] != grid[j][i]) count = 0;
                count++;
                if (count == m) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}