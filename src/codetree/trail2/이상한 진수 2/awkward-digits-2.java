import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        int[] binary = new int[a.length()];

        boolean isChanged = false;
        for (int i = 0; i < a.length(); i++) {
            int num = a.charAt(i) - '0';
            if (isChanged == false && num == 0) {
                num = 1;
                isChanged = true;
            }
            binary[i] = num;
        }

        if (isChanged == false) binary[a.length() - 1] = 0;

        int result = 0;
        for (int i = 0; i < binary.length; i++) {
            result += binary[i] * (int) Math.pow(2, binary.length - i - 1);
        }

        System.out.println(result);
    }
}