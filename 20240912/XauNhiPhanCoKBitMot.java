import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XauNhiPhanCoKBitMot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            System.out.println(generateAB(n, k));
        }
    }

    private static List<String> generateAB(int n, int k) {
        List<String> results = new ArrayList<>();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "0";
        }
        while (!results.contains(str)) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    count++;
                    if (count > k) {
                        break;
                    }
                }
            }
            if (count == k) {
                results.add(str);
            }
            str = nextGeneration(str);
        }

        return results;
    }

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
}
