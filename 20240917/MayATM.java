import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MayATM {
    static int n, k;
    static int[] a;
    static int minn;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            a = new int[n];
            boolean ok = false;

            list = new ArrayList<>();
            minn = n + 1;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == k) {
                    ok = true;
                }
            }
            if (ok) {
                System.out.println(1);
            } else {
                backTrack(0, k, 0);
                if (minn == n + 1) {
                    System.out.println(-1);
                } else {
                    System.out.println(minn);
                }
            }

        }
    }

    private static void backTrack(int i, int sum, int cnt) {
        if (sum == 0 && cnt < minn) {
            // System.out.println(sum + " " + cnt);
            // System.out.println(list);
            minn = cnt;
        } else {
            for (int j = i; j < n; j++) {

                if (sum >= a[j]) {
                    list.add(j);
                    backTrack(j + 1, sum - a[j], cnt + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
