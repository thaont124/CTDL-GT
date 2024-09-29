import java.util.Arrays;
import java.util.Scanner;

public class TimMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long MOD = 1000000007;

        int t = scanner.nextInt();

        while (t-- > 0) {
            long max = 0;
            int n = scanner.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }

            Arrays.sort(a);

            for (int i = 0; i < n; i++) {
                max = (max % MOD + (a[i] * i) % MOD) % MOD;
            }

            System.out.println(max);
        }

    }
}
