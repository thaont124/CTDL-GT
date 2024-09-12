import java.util.Arrays;
import java.util.Scanner;

public class HoanViKeTiep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(Arrays.toString(nextGeneration(a)));
        }
    }

    private static int[] nextGeneration(int[] a) {
        int n = a.length;
        int i = n - 2;
        int j = n - 1;
        while (a[i] > a[i + 1]) {
            i--;
            if (i == -1) {
                break;
            }
        }

        if (i == -1) {
            for (int k = 0; k < n; k++) {
                a[k] = k + 1;
            }
            return a;
        }
        while (a[i] > a[j]) {
            j--;
        }

        int t = a[i];
        a[i] = a[j];
        a[j] = t;

        for (int k = i + 1; k < n; k++) {
            int minidx = k;
            for (int h = k + 1; h < n; h++) {
                if (a[h] < a[minidx]) {
                    minidx = h;
                }
            }
            t = a[k];
            a[k] = a[minidx];
            a[minidx] = t;
        }

        return a;
    }
}