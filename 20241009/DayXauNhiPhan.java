import java.util.Scanner;

public class DayXauNhiPhan {
    static long[] f = new long[93];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= 92; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            System.out.println(solve(n, k));
        }
    }

    public static char solve(int n, long k) {
        if (n == 1) {
            return '0';
        }
        if (n == 2) {
            return '1';
        }
        if (k > f[n - 2]) {
            return solve(n - 1, k - f[(int) (n - 2)]);
        }
        return solve(n - 2, k);
    }
}