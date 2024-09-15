import java.util.Scanner;

public class LocPhat {
    static boolean ok;

    static boolean test1(String s, int n) {

        return s.charAt(0) == '8' && s.charAt(n - 1) == '6' && s.length() >= 6;
    }

    static boolean test2(String s, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '8') {
                count++;
                if (count > 1) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }

    static boolean test3(String s, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '6') {
                count++;
                if (count > 3) {
                    return false;
                }
            } else {
                count = 0;
            }
        }
        return true;
    }

    static void in(String s) {
        System.out.println(s);
    }

    static String sinh(String s, int n) {
        char[] arr = s.toCharArray();
        int i = n - 1;
        while (i >= 0 && arr[i] != '6') {
            arr[i] = '6';
            i--;
        }
        if (i >= 0) {
            arr[i] = '8';
        } else {
            ok = true;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ok = false;
        int n = sc.nextInt();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += '6';
        }
        while (!ok) {
            if (test1(s, n) && test2(s, n) && test3(s, n)) {
                in(s);
            }
            s = sinh(s, n);
        }
        sc.close();
    }
}
