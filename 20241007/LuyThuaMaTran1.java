import java.util.Scanner;

public class LuyThuaMaTran1 {
    static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[][] a = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextLong();
                }
            }
            a = pow(a, k);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static long[][] nhanMaTran(long[][] a, long[][] b) {
        int n = a.length;
        long[][] c = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0L;
                for (int k = 0; k < n; k++) {
                    c[i][j] = (c[i][j] % mod + ((a[i][k] % mod) * (b[k][j] % mod)) % mod) % mod;
                }
            }
        }
        return c;
    }

    public static long[][] pow(long[][] a, long k) {
        if (k <= 1) {
            return a;
        }
        long[][] x = pow(a, k / 2);
        if (k % 2 == 0) {
            return nhanMaTran(x, x);
        }
        return nhanMaTran(a, nhanMaTran(x, x));
    }
}