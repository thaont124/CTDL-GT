
import java.util.Arrays;
import java.util.Scanner;

public class KhoangCachNhoHonK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int x = firstIndexGreater(a, a[i] + k, i + 1, n);
                cnt += x - i - 1;
            }

            System.out.println(cnt);
        }
    }

    private static int firstIndexGreater(int[] array, int value, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
