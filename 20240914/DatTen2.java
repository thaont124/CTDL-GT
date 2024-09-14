import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatTen2 {

    static List<int[]> idx = new ArrayList<>();
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            a = new int[k + 1];

            for (int i = 1; i <= k; i++) {
                a[i] = i;
            }

            backTrack(n, k, 1);

            for (int i = 0; i < idx.size(); i++) {
                for (int j = 1; j <= k; j++) {
                    System.out.print((char) (idx.get(i)[j] + 64));
                }
                System.out.println();
            }
        }
    }

    private static void backTrack(int n, int k, int i) {
        for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k) {
                // System.out.println(Arrays.toString(a));
                idx.add(a.clone());
            } else {
                backTrack(n, k, i + 1);
            }
        }
    }

}
