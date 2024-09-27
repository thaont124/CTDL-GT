
import java.util.Arrays;
import java.util.Scanner;

public class SapXepThamLam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            boolean check = true;
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                b[i] = a[i];
            }
            Arrays.sort(b);
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i] && a[i] != b[n - i - 1]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
