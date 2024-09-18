
import java.util.Scanner;

public class DiChuyenTrongMaTran {
    static int n, m;
    static int[][] matrix;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            cnt = 0;
            matrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            backTrack(0, 0);
            System.out.println(cnt);
        }
    }

    private static void backTrack(int i, int j) {
        // System.out.println(i + " " + j + " " + cnt);
        if (i == n - 1 && j == m - 1) {
            cnt++;
        }

        if (i + 1 <= n - 1 && j <= m - 1) {
            backTrack(i + 1, j);
        }
        if (i <= n - 1 && j + 1 <= m - 1) {
            backTrack(i, j + 1);
        }

    }
}

/*
 * 2
 * 3 2
 * 1 2 3
 * 4 5 6
 * 2 2
 * 1 2
 * 3 4
 */