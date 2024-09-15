import java.util.Arrays;
import java.util.Scanner;

public class HoanViDaySo {
    static int[] arr;
    static int[] result;
    static int dd[];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        dd = new int[n + 1];
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dd[i] = 0;
        }
        Arrays.sort(arr);
        backtrack(1);
    }

    private static void in() {
        for (int j = 1; j <= n; j++)
            System.out.print(result[j] + " ");
        System.out.println();
    }

    private static void backtrack(int i) {
        if (i > n)
            in();
        for (int j = 1; j <= n; j++)
            if (dd[j] == 0) {
                dd[j] = 1;
                result[i] = arr[j];
                backtrack(i + 1);
                dd[j] = 0;
            }
    }
}
