import java.util.Scanner;

public class NguoiDiDuLich {
    static int n;
    static int[][] matrix;
    static int dd[];
    static int minn;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        matrix = new int[n][n];
        dd = new int[n];
        minn = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                minn += matrix[i][j];
            }
        }
        dd[0] = 1;
        backTrack(1, 0, 0);
        System.out.println(minn);
    }

    private static void backTrack(int i, int start, int cost) {
        // System.out.println(start + " " + cost);
        if (cost >= minn) {
            return;
        }
        if (i == n) {

            if (cost + matrix[start][0] < minn) {
                minn = cost + matrix[start][0];
            }

        }

        for (int j = 0; j < n; j++) {
            if (dd[j] == 0 && j != i) {
                dd[j] = 1;
                backTrack(i + 1, j, cost + matrix[start][j]);
                dd[j] = 0;
            }
        }
    }
}
