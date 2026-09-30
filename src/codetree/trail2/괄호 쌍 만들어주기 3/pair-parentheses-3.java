import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        int open = 0;
        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') open++;
            else if (A.charAt(i) == ')') result += open;
        }

        System.out.println(result);
    }
}