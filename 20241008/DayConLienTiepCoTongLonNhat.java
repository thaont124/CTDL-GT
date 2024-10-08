
import java.util.Scanner;

public class DayConLienTiepCoTongLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(maxSubArrSum(a, 0, n - 1));
        }

    }

    private static int maxSubArrSum(int[] a, int l, int h) {
        if (l == h) {
            return a[l];
        }
        int m = (l + h) / 2;
        return (Math.max(
                Math.max(maxSubArrSum(a, l, m), maxSubArrSum(a, m + 1, h)),
                maxCrossingSum(a, l, m, h)));
    }

    private static int maxCrossingSum(int[] a, int l, int m, int h) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += a[i];
            if (leftSum < sum) {
                leftSum = sum;
            }
        }

        sum = 0;
        for (int i = m + 1; i <= h; i++) {
            sum += a[i];
            if (rightSum < sum) {
                rightSum = sum;
            }
        }
        // System.out.println(leftSum + " " + rightSum);
        return leftSum + rightSum;
    }
}