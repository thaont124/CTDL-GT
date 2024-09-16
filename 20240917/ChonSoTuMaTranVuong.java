/*
 * Mỗi hàng, mỗi cột của ma trận lấy 1 phần tử sao cho tổng các phần tử  = k
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChonSoTuMaTranVuong {
    static int n, k;
    static int[][] a;
    static int[] ddHang, ddCot;
    static List<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n][n];
        ddHang = new int[n];
        ddCot = new int[n];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        backTrack(0, k);
    }

    private static void backTrack(int i, int sum) {

        if (sum == 0 && result.size() == n) {
            System.out.println(result);
        } else {
            for (int k = 0; k < n; k++) {
                // System.out.println("add: " + i + " " + k + " " + Arrays.toString(ddCot) + " "
                // + result);
                if (ddCot[k] == 0) {
                    if (sum < a[i][k]) {
                        continue;
                    }
                    ddCot[k] = 1;
                    result.add(k + 1);
                    backTrack(i + 1, sum - a[i][k]);
                    ddCot[k] = 0;
                    result.remove(result.size() - 1);

                }

            }
        }

    }
}

/*
 * 3 10
 * 2 4 3
 * 1 3 6
 * 4 2 4
 */