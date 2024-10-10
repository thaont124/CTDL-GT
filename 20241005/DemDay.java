import java.util.Scanner;

public class DemDay {
    static long mod = 123456789;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(pow(2, n - 1));
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
