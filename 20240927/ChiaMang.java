import java.util.Arrays;
import java.util.Scanner;

public class ChiaMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

            }
            Arrays.sort(a);
            int x = 0;
            int y = 0;
            int maxLen = Math.min(k, n - k);

            for (int i = 0; i < n; i++) {
                if (i < maxLen) {
                    y += a[i];
                } else {
                    x += a[i];
                }
            }
            // System.out.println(x + " " + y);
            int result = x > y ? x - y : x - y;
            System.out.println(result);
        }
    }
}
