import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToHopSoTongBangX {
    static int n, k;
    static int[] a;
    static List<List<Integer>> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[n];
            result = new ArrayList<>();

            List<Integer> toHop = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

            }

            backTrack(k, toHop);

            if (result.isEmpty()) {
                System.out.println(-1);
            } else {
                for (List<Integer> elem : result) {
                    System.out.print(elem + " ");
                }
            }
            System.out.println();
        }
    }

    private static void backTrack(int sum, List<Integer> toHop) {
        List<Integer> list = new ArrayList<>(toHop);
        if (sum == 0) {
            // System.out.println(toHop);
            result.add(list);
        } else {
            for (int i = 0; i < a.length; i++) {
                if (sum < a[i] || (!list.isEmpty() && list.get(list.size() - 1) > a[i])) {
                    continue;
                }

                list.add(a[i]);
                backTrack(sum - a[i], list);
                list.remove(list.size() - 1);
            }
        }

    }
}
/*
 * 2
 * 4 8
 * 2 4 6 8
 * 2 5
 * 6 7
 */