
import java.util.Scanner;

public class XauNhiPhanKeTiep {
    private static String nextGeneration(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = sb.length() - 1;

        while (i >= 0 && sb.charAt(i) == '1') {
            sb.setCharAt(i, '0');
            i--;
        }

        if (i >= 0) {
            sb.setCharAt(i, '1');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            String str = scanner.next();
            System.out.println(nextGeneration(str));
        }
    }
}