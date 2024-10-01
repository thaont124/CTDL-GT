
import java.util.Scanner;

public class PhanSoDonVi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long p = scanner.nextInt();
            long q = scanner.nextInt();

            while (q % p != 0) {
                long x = q / p;
                System.out.print(1 + "/" + (x + 1) + " + ");
                p = (x + 1) * p - q;
                q = (x + 1) * q;
            }
            System.out.println(1 + "/" + (q / p));
        }
    }
}
