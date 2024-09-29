
import java.util.Arrays;
import java.util.Scanner;

public class GiaTriNhoNhatCuaBieuThuc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextLong();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            String s = "0";
            long sum = 0;
            for (int i = 0; i < n; i++) {
                String mul = multiply(String.valueOf(a[i]), String.valueOf(b[n - i - 1]));
                s = sum(s, mul);
                // sum += (a[i] * b[n - i - 1]);
            }
            System.out.println(s);
        }
    }

    private static String sum(String a, String b) {
        while (a.length() < b.length())
            a = "0" + a;
        while (a.length() > b.length())
            b = "0" + b;

        int len = a.length();
        String res = "";
        int carry = 0;

        for (int i = len - 1; i >= 0; i--) {
            int digitSum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            res = (digitSum % 10) + "" + res;
            carry = digitSum / 10;
        }

        if (carry > 0)
            res = carry + "" + res;

        return res;
    }

    public static String multiply(String a, String b) {
        if (a.equals("0") || b.equals("0"))
            return "0";

        int lenA = a.length();
        int lenB = b.length();
        int[] result = new int[lenA + lenB];

        for (int i = lenA - 1; i >= 0; i--) {
            int n1 = a.charAt(i) - '0'; // Chuyển đổi ký tự thành số nguyên
            for (int j = lenB - 1; j >= 0; j--) {
                int n2 = b.charAt(j) - '0';
                int sum = n1 * n2 + result[i + j + 1]; // Tính tổng tại vị trí i+j+1

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        String s = "";
        for (int num : result) {
            if (!(s.length() == 0 && num == 0)) {
                s += String.valueOf(num);
            }
        }

        return s;
    }
}
