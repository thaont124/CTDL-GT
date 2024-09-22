import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DatTen1 {
    static int[] a;
    static int n, k;
    static String[] str;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }

        read(s);
        a = new int[k + 1];
        Try(1);
    }

    private static void read(String[] s) {
        Set<String> uniqueStrings = new TreeSet<>();
        Collections.addAll(uniqueStrings, s);
        n = uniqueStrings.size();
        str = new String[n];
        int idx = 0;
        for (String value : uniqueStrings) {
            str[idx++] = value;
        }
    }

    private static void print() {
        for (int i = 1; i <= k; i++) {
            System.out.print(str[a[i] - 1] + " ");
        }
        System.out.println();
    }

    static void Try(int i) {
        for (int j = a[i - 1] + 1; j <= n - k + i; j++) {
            a[i] = j;
            if (i == k) {
                print();
            } else {
                Try(i + 1);
            }
        }
    }
}
