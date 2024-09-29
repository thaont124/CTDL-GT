
import java.util.Scanner;

public class SapXepCongViec1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] s = new int[n];
            int[] f = new int[n];

            for (int i = 0; i < n; i++) {
                s[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                f[i] = scanner.nextInt();
            }
            quickSort(f, s, 0, n - 1); // nlogn

            int crr = f[0];
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (s[i] >= crr) {
                    cnt++;
                    crr = f[i];
                }
            }
            System.out.println(cnt);

        }
    }

    public static void quickSort(int[] a, int[] b, int start, int finish) {

        if (start < finish) {
            int pivot = partition(a, b, start, finish);

            quickSort(a, b, start, pivot - 1);
            quickSort(a, b, pivot + 1, finish);
        }
    }

    public static int partition(int[] a, int[] b, int start, int finish) { // phân vùng
        int pivot = a[finish];
        int i = start;
        for (int j = start; j < finish; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                swap(b, i, j);
                i++;
            }
        }
        swap(a, i, finish);
        swap(b, i, finish);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}