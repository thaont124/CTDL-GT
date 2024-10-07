import java.util.Scanner;

public class SoFibonacciThuN {
    static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long[][] a = {
                    { 1L, 1L },
                    { 1L, 0L }
            };
            a = pow(a, n);
            System.out.println(a[0][1]);
        }
    }

    public static long[][] nhanMaTran(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                c[i][j] = 0L;
                for (int k = 0; k <= 1; k++) {
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