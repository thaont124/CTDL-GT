import java.util.Scanner;

public class DayConTangDaiNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int maxx = 0;
            int[] f = new int[n];
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                f[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                maxx = Math.max(maxx, f[i]);
            }
            System.out.println(n - maxx);
        }

    }
}
// 1 2 5 4 6 2