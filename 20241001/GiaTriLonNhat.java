
import java.util.Scanner;

public class GiaTriLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] a = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            sum += a[i] + Math.abs(a[i]);
        }
        System.out.println(sum);

    }

}
