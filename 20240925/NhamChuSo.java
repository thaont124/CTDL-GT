import java.util.Scanner;

public class NhamChuSo {
    private static String a, b;

    private static String sum() {
        while (a.length() < b.length())
            a = "0" + a;
        while (a.length() > b.length())
            b = "0" + b;
        int len = a.length();
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int digitSum = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            res.insert(0, (char) (digitSum % 10 + '0'));
            carry = digitSum / 10;
        }
        if (carry > 0)
            res.insert(0, (char) (carry + '0'));
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.next();
        b = scanner.next();

        a = a.replace('6', '5');
        b = b.replace('6', '5');
        System.out.println(sum() + " ");

        a = a.replace('5', '6');
        b = b.replace('5', '6');
        System.out.println(sum() + " ");
        scanner.close();
    }
}
