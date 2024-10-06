
import java.util.Scanner;

public class GapDoiDaySo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            System.out.println(solve(n, k));
        }
    }

    public static long solve(long n, long k) {
        long x = (long) Math.pow(2, n - 1);// tính độ dài tới trung tâm
        if (k == x) {
            return n;
        }
        if (k < x) {
            return solve(n - 1, k);
        }

        return solve(n - 1, k - x);
    }
}