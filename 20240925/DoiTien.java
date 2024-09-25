import java.util.Scanner;

public class DoiTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = { 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
        int t = scanner.nextInt();
        while (t-- > 0) {
            int x = scanner.nextInt();
            int res = 0;
            for (int j = 0; j < a.length; j++) {
                res += x / a[j];
                x = x % a[j];
            }
            System.out.println(res);
        }
    }
}
