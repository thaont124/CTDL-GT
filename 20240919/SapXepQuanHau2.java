import java.util.Scanner;

public class SapXepQuanHau2 {
    private static int n;
    private static int[][] matrix;
    private static int[] a;
    private static boolean[] b;
    private static boolean[] xuoi;
    private static boolean[] nguoc;
    private static int maxx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = 8;
            a = new int[n + 1];
            b = new boolean[n + 1];
            xuoi = new boolean[2 * n + 2];
            nguoc = new boolean[2 * n + 2];
            matrix = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i <= n; i++) {
                b[i] = false;
                xuoi[i] = false;
                nguoc[i] = false;
            }
            maxx = 0;
            backTrack(1, maxx);
            System.out.println(maxx);
        }
    }

    private static void backTrack(int i, int sum) {
        for (int j = 1; j <= n; j++) {
            if (!b[j] && !xuoi[i - j + n] && !nguoc[i + j - 1]) {

                b[j] = true;
                xuoi[i - j + n] = true;
                nguoc[i + j - 1] = true;
                if (i == n) {
                    if (sum + matrix[i][j] > maxx) {
                        maxx = sum + matrix[i][j];

                    }
                } else {
                    backTrack(i + 1, sum + matrix[i][j]);
                }
                b[j] = false;
                xuoi[i - j + n] = false;
                nguoc[i + j - 1] = false;
            }
        }
    }
}