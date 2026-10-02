import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        
        int consecutiveOpen = 0;
        int result = 0;
        
        for (int i = 0; i < A.length() - 1; i++) {
            if (A.charAt(i) == '(' && A.charAt(i + 1) == '(') {
                consecutiveOpen++;
            }
            if (A.charAt(i) == ')' && A.charAt(i + 1) == ')') {
                result += consecutiveOpen;
            }
        }

        System.out.println(result);
    }
}