import java.util.Scanner;

public class SoNhoNhat {
    static int minn;
    static int n;
    static int d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            d = scanner.nextInt();
            minn = Integer.MAX_VALUE;

            backTrack(1, n, 0);

            if (minn == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(minn);
            }
        }
    }

    private static void backTrack(int i, int sum, int currentResult) {
        // System.out.println(i + " " + sum + " " + currentResult);
        if (sum < 0 || (i == d && sum - 9 > 10)) {
            return;

        }
        if (i == d + 1) {
            if (sum == 0 && currentResult < minn) {
                minn = currentResult;

            }
            return;

        }

        for (int j = 0; j <= 9; j++) {
            if (j == 0 && i == 1) {
                continue;

            }
            backTrack(i + 1, sum - j, currentResult * 10 + j);
        }
    }
}
