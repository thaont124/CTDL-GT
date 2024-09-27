import java.util.Arrays;
import java.util.Scanner;

public class TongNhoNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] < 0 || a[i] > 9) {
                    System.out.println("invalid");
                    return;
                }
            }
            Arrays.sort(a);
            int x = 0;
            int y = 0;

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    y = y * 10 + a[i];
                } else {
                    x = x * 10 + a[i];
                }
            }
            // System.out.println(x + " " + y);
            System.out.println(x + y);
        }
    }
}
