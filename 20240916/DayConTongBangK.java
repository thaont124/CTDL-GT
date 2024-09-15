
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayConTongBangK {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] a = new int[n];
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            Arrays.sort(a);
            backTrack(0, sum, a, result);
            System.out.println();
        }
    }

    private static void backTrack(int i, int sum, int[] a, List<Integer> result) {
        // System.out.println(result);

        if (sum == 0) {
            System.out.print(result + " ");
        } else {
            for (int j = i; j < a.length; j++) {

                if (sum - a[j] < 0) {
                    break;
                }
                result.add(a[j]);
                backTrack(j + 1, sum - a[j], a, result);
                result.remove(result.size() - 1);

            }
        }
    }
}

/*
 * 2
 * 5 50
 * 5 10 15 20 25
 * 8 53
 * 15 22 14 26 32 9
 */