
import java.util.Scanner;

public class DoiChoCacChuSo {
    static int k;
    static String maxx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            maxx = "";
            k = sc.nextInt();
            String s = sc.next();
            backtrack(s.toCharArray(), 0, 0);
            System.out.println("max of " + s + " is " + maxx);
        }
    }

    public static void backtrack(char[] s, int i, int cnt) {
        if (i >= s.length || cnt >= k) {
            return;
        }

        char c = s[i];
        for (int j = i + 1; j < s.length; j++) {
            c = (char) Math.max(c, s[j]); // Tìm ký tự lớn nhất từ vị trí i
        }

        if (s[i] == c) { // nếu đã lớn nhất
            backtrack(s, i + 1, cnt);
        } else {
            for (int j = i + 1; j < s.length; j++) {
                if (s[j] == c) {
                    swap(s, i, j);
                    maxx = max(maxx, new String(s));
                    backtrack(s, i + 1, cnt + 1);
                    swap(s, i, j);
                }
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static String max(String a, String b) {
        return (a.compareTo(b) > 0) ? a : b;
    }
}
