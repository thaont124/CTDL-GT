import java.util.Scanner;

public class TichHaiDaThuc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int[] result = new int[n + m - 1];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result[i + j] += karatsuba(a[i], b[j]);
                }
            }
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }

    public static long karatsuba(long x, long y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (x < 10 || y < 10) {
            return x * y;
        }
        int n = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
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
