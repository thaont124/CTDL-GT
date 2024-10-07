import java.util.Scanner;

public class HeCoSoK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            String result = sum(a, b, k);
            System.out.println(result);
        }
    }

    private static String sum(String a, String b, int k) {
        while (a.length() < b.length())
            a = "0" + a;
        while (a.length() > b.length())
            b = "0" + b;

        int len = a.length();
        String res = "";
        int carry = 0;

        for (int i = len - 1; i >= 0; i--) {
            int digitSum = charToValue(a.charAt(i)) + charToValue(b.charAt(i)) + carry;
            res = valueToChar((digitSum % k)) + "" + res;
            carry = digitSum / k;
        }

        if (carry > 0)
            res = carry + "" + res;

        return res;
    }

    private static int charToValue(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return c - 'A' + 10;
        }
    }

    public static char valueToChar(int value) {
        if (value >= 0 && value <= 9) {
            return (char) (value + '0');
        } else {
            return (char) (value - 10 + 'A');
        }
    }

}