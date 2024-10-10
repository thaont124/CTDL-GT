
import java.util.Scanner;

public class LuyThua {
    static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            System.out.println(pow(n, k));
        }
    }

    public static long pow(long n, long k) {
        if (k == 1) {
            return n % mod;
        }
        if (k == 0) {
            return 1L;
        }
        long x = pow(n, k / 2);
        if (k % 2 == 0) {
            return ((x % mod) * (x % mod)) % mod;
        }
        return ((((x % mod) * (x % mod)) % mod) * (n % mod)) % mod;
    }
}