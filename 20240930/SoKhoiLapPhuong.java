
import java.util.Scanner;

public class SoKhoiLapPhuong {
    public static String removeCharAt(String s, int i) {
        String result = s.substring(0, i) + s.substring(i + 1);
        // System.out.println("Sau bo chu: " + result);
        return result.equals("") ? "0" : result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();
            long max = -1L;
            for (int i = 0; i < s.length(); i++) {
                long after = Long.parseLong(removeCharAt(s, i));

                long n = (long) Math.round(Math.pow(after, 1.0 / 3.0));
                if (n * n * n == after) {
                    max = Math.max(n, max);
                }
            }
            System.out.println(max);
        }
    }
}