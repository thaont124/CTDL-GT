
import java.util.Scanner;

public class DayConChungDaiNhatCuaBaXau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int l = scanner.nextInt();

            String x = scanner.next();
            String y = scanner.next();
            String z = scanner.next();

            System.out.println(solve(x, y, z));
        }
    }

    private static int solve(String x, String y, String z) {
        int[][][] f = new int[x.length() + 1][y.length() + 1][z.length() + 1];

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                for (int k = 1; k <= z.length(); k++) {
                    if (x.charAt(i - 1) == y.charAt(j - 1) && y.charAt(j - 1) == z.charAt(k - 1)) {
                        f[i][j][k] = f[i - 1][j - 1][k - 1] + 1;
                    } else {
                        f[i][j][k] = Math.max(f[i - 1][j][k],
                                Math.max(f[i][j - 1][k], f[i][j][k - 1]));
                    }
                }
            }
        }
        return f[x.length()][y.length()][z.length()];
    }

}
