import java.util.Arrays;
import java.util.Scanner;

public class ToHopTiepTheo {
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
            a = nextGeneration(n, k, a);
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (check[a[i]] == 0) {
                    count++;
                }
            }
            System.out.println("Kq: " + Arrays.toString(a) + " " + count);
        }
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
}

// 4
// 5 3
// 1 4 5
// 5 3
// 1 3 5
// 6 4
// 3 4 5 6
// 6 4
// 1 3 4 5
