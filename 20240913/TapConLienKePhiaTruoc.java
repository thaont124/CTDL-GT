import java.util.Arrays;
import java.util.Scanner;

public class TapConLienKePhiaTruoc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(previousGeneration(n, k, a)));
        }
    }

    private static int[] previousGeneration(int n, int k, int[] a) {
        int i = k - 1;
        while (a[i] - 1 <= a[i - 1]) {
            i--;
            if (i == 0) {
                break;
            }
        }
        if (i == 0 && a[0] == 1) {
            for (int j = 0; j < k; j++) {
                a[j] = n - k + j + 1;
            }
            return a;
        }

        a[i]--;
        for (int j = i + 1; j < k; j++) {
            a[j] = n - k + j + 1;
        }
        return a;
    }
}
// 15
// 6 4
// 1 2 3 4
// 6 4
// 1 2 3 5
// 6 4
// 1 2 3 6
// 6 4
// 1 2 4 5
// 6 4
// 1 2 4 6
// 6 4
// 1 2 5 6
// 6 4
// 1 3 4 5
// 6 4
// 1 3 4 6
// 6 4
// 1 3 5 6
// 6 4
// 1 4 5 6
// 6 4
// 2 3 4 5
// 6 4
// 2 3 4 6
// 6 4
// 2 3 5 6
// 6 4
// 2 4 5 6
// 6 4
// 3 4 5 6
