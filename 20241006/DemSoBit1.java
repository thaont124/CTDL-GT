import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemSoBit1 {
    static List<Long> a;

    static void findCenter(long n) {
        int i = 0; // vi tri trung tam thu i
        long idx = 1; // vi tri trung tam: 2^i

        while (n / 2 > 0) {
            i++;
            if (i == 1) {
                a.add(2L);
                idx = 2;
            } else {
                idx *= 2;
                a.add(idx);
            }

            n /= 2;
        }
    }

    static long solve(long k, long n, long lastCenter) {
        if (k % 2 == 1) {
            return 1;
        }
        if (k < a.get((int) lastCenter)) {
            return solve(k, n / 2, lastCenter - 1);
        } else if (k == a.get((int) lastCenter)) {
            return n % 2;
        } else {
            return solve(2 * a.get((int) lastCenter) - k, n / 2, lastCenter - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            a = new ArrayList<>();
            long n = sc.nextLong();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long res = 0;
            findCenter(n);

            for (long i = l; i <= r; i++) {
                res += solve(i, n, a.size() - 1);
            }
            System.out.println(res);
        }
    }
}
