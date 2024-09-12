import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XauABDoDaiN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int n = scanner.nextInt();
            System.out.println(generateAB(n));
        }
    }

    private static List<String> generateAB(int n) {
        List<String> results = new ArrayList<>();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "A";
        }
        while (!results.contains(str)) {
            results.add(str);
            str = nextGeneration(str);
        }

        return results;
    }

    private static String nextGeneration(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = sb.length() - 1;

        while (i >= 0 && sb.charAt(i) == 'B') {
            sb.setCharAt(i, 'A');
            i--;
        }

        if (i >= 0) {
            sb.setCharAt(i, 'B');
        }

        return sb.toString();
    }

}
