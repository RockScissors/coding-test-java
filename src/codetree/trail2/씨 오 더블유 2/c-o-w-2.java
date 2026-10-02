import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        
        int CCount = 0;
        int COCount = 0;
        int COWCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'C') CCount++;
            if (str.charAt(i) == 'O') COCount += CCount;
            if (str.charAt(i) == 'W') COWCount += COCount;
        }

        System.out.println(COWCount);
    }
}