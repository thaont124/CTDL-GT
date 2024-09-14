import java.util.Arrays;
import java.util.Scanner;

public class SoThuTuHoanVi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println("số thự tự hoán vị của " + Arrays.toString(a) + " là: " + position(a));
        }
    }

    public static int position(int a[]) {
        int n = a.length;
        int count = 1;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        while (!checkArr(a, arr, n)) {
            // System.out.println(Arrays.toString(arr));
            arr = nextGeneration(arr);
            count++;
        }

        return count;
    }

    public static int[] nextGeneration(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (a[i] > a[i + 1]) {
            i--;
            if (i == -1) {
                break;
            }
        }

        if (i == -1) {
            return a;
        }

        int minidx = i;
        for (int j = n - 1; j > i; j--) {
            if (a[i] < a[j]) {
                minidx = j;
                break;
            }
        }
        int temp = a[i];
        a[i] = a[minidx];
        a[minidx] = temp;

        for (int k = i + 1; k < n; k++) {
            int idx = k;
            for (int h = k + 1; h < n; h++) {
                if (a[h] < a[idx]) {
                    idx = h;
                }
            }
            int t = a[k];
            a[k] = a[idx];
            a[idx] = t;
        }

        return a;
    }

    public static boolean checkArr(int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}