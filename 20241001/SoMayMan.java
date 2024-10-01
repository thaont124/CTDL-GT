
import java.util.Scanner;

public class SoMayMan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = "";
            for (int i = 0; i <= n / 4; i++) { // i: so so 4
                if ((n - i * 4) % 7 == 0) {
                    System.out.println(i + " " + ((n - i * 4) / 7) + " " + s);

                    for (int j = 0; j < i; j++) {
                        s += "4";
                    }
                    for (int j = 0; j < (n - i * 4) / 7; j++) {
                        s += "7";
                    }
                    break;
                }
            }
            if (s.equals("")) {
                System.out.println(-1);
            } else {
                System.out.println(s);
            }
        }
    }

}