import java.util.Arrays;
import java.util.Scanner;

public class TapConKeTiep {
    private static int[] nextGeneration(int n, int k, int[] a) {
        int i = k;
        while (a[i - 1] == n - k + i) {
            i--;
            if (i == 0) {
                break;
            }
        }

        if (i == 0) {
            for (int j = 0; j < k; j++) {
                a[j] = j + 1;
            }
        } else {
            a[i - 1]++;
            for (int j = i; j < k; j++) {
                a[j] = a[j - 1] + 1;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(Arrays.toString(nextGeneration(n, k, a)));
        }
    }
}

// 4
// 5 3
// 1 4 5
// 5 3
// 3 4 5
// 6 4
// 2 3 5 6
// 6 4
// 1 3 4 5
