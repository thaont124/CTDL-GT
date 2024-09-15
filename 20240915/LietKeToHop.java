import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class LietKeToHop {
    static int[] arr;
    static int[] idx;
    static int k;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        idx = new int[k + 1];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }
        read(a);
        backtrack(1);
    }

    private static void read(int[] a) {
        Set<Integer> unique = new TreeSet<>();

        for (int value : a) {
            unique.add(value);
        }

        n = unique.size();
        arr = new int[n + 1];
        int index = 1;

        for (Integer value : unique) {
            arr[index++] = value;
        }
    }

    private static void in() {
        for (int j = 1; j <= k; j++)
            System.out.print(arr[idx[j]] + " ");
        System.out.println();
    }

    private static void backtrack(int i) {
        // System.out.println(Arrays.toString(idx));
        if (i > k)
            in();
        else {
            for (int j = idx[i - 1] + 1; j <= n - k + i; j++) {
                idx[i] = j;
                backtrack(i + 1);
            }
        }

    }
}
