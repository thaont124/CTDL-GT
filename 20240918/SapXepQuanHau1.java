import java.util.Scanner;

public class SapXepQuanHau1 {
    private static int[] a;
    private static boolean[] b;
    private static boolean[] xuoi;
    private static boolean[] nguoc;
    private static int dem = 0;
    private static int n;

    private static void backTrack(int i) {
        for (int j = 1; j <= n; j++) {
            if (!b[j] && !xuoi[i - j + n] && !nguoc[i + j - 1]) {
                a[i] = j;
                b[j] = true;
                xuoi[i - j + n] = true;
                nguoc[i + j - 1] = true;
                if (i == n) {
                    dem++;
                } else {
                    backTrack(i + 1);
                }
                b[j] = false;
                xuoi[i - j + n] = false;
                nguoc[i + j - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n + 1];
            b = new boolean[n + 1];
            xuoi = new boolean[2 * n + 2];
            nguoc = new boolean[2 * n + 2];

            for (int i = 0; i <= n; i++) {
                b[i] = false;
                xuoi[i] = false;
                nguoc[i] = false;
            }
            dem = 0;
            backTrack(1);
            System.out.println(dem);
        }
        scanner.close();
    }
}
