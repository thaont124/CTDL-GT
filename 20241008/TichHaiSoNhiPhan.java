
import java.util.Scanner;

public class TichHaiSoNhiPhan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String a = scanner.next();
            String b = scanner.next();
            Long num1 = Long.parseLong(a, 2);
            Long num2 = Long.parseLong(b, 2);
            // System.out.println(num1 * num2);
            System.out.println(karatsuba(num1, num2));
        }
    }

    public static long karatsuba(long x, long y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (x < 10 || y < 10) {
            return x * y;
        }

        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int halfN = n / 2;

        long high1 = x / (long) Math.pow(10, halfN);
        long low1 = x % (long) Math.pow(10, halfN);
        long high2 = y / (long) Math.pow(10, halfN);
        long low2 = y % (long) Math.pow(10, halfN);

        long z0 = karatsuba(low1, low2);
        long z1 = karatsuba(low1 + high1, low2 + high2);
        long z2 = karatsuba(high1, high2);

        return z2 * (long) Math.pow(10, 2 * halfN) + (z1 - z2 - z0) * (long) Math.pow(10, halfN) + z0;
    }

}
