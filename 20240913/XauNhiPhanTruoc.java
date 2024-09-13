import java.util.Scanner;

public class XauNhiPhanTruoc {
    private static String previousGeneration(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = sb.length() - 1;

        while (i >= 0 && sb.charAt(i) == '0') {
            sb.setCharAt(i, '1');
            i--;
        }

        if (i >= 0) {
            sb.setCharAt(i, '0');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            String str = scanner.next();
            System.out.println(previousGeneration(str));
        }
    }
}
