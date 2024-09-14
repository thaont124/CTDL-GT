import java.util.Arrays;
import java.util.Scanner;

public class SoThuTuToHop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[k];
            int[] check = new int[n + 1];
            for (int i = 0; i < k; i++) {
                a[i] = scanner.nextInt();
                check[a[i]] = 1;
            }
            System.out.println("Kq: " + Arrays.toString(a) + " " + position(a, n, k));
        }
    }

    public static int position(int a[], int n, int k) {

        int count = 1;
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = i + 1;
        }

        while (!checkArr(a, arr, k)) {
            // System.out.println(Arrays.toString(arr));
            arr = nextGeneration(n, k, arr);
            count++;
        }

        return count;
    }

    private static int[] nextGeneration(int n, int k, int[] a) {
        int i = k;
        while (a[i - 1] == n - k + i) {
            i--;
            if (i == 0) {
                break;
            }
        }

        if (i == 0) { // nếu là phần tử cuối cùng thì trả tất cả về giá trị 0
            for (int j = 0; j < k; j++) {
                a[j] = 0;
            }
        } else {
            a[i - 1]++;
            for (int j = i; j < k; j++) {
                a[j] = a[j - 1] + 1;
            }
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
