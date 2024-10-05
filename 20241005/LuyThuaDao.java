import java.util.Scanner;

public class LuyThuaDao {
    static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = n;
            long r = 0;
            while (k != 0) {
                r = r * 10 + k % 10;
                k /= 10;
            }
            System.out.println(pow(n, r));
        }
    }

    public static long pow(long n, long k) {
        if (k == 1) {
            return n;
        }
        if (k == 0) {
            return 1L;
        }
        long x = pow(n, k / 2);
        if (k % 2 == 0) {
            return ((x % mod) * (x % mod)) % mod;
        }
        return ((((x % mod) * (x % mod)) % mod) * n % mod) % mod;
    }
}
