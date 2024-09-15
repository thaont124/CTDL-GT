
import java.util.Scanner;

public class HoanViXauKiTu {
    static int[] dd;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            dd = new int[s.length() + 1];
            String result = "";
            backTrack(0, s, result);
            System.out.println();
        }

    }

    private static void backTrack(int i, String s, String result) {
        // System.out.println(s + " " + result);
        if (i == s.length()) {
            System.out.print(result + " ");
        } else {
            for (int j = 0; j < s.length(); j++) {
                if (dd[j] == 0) {
                    dd[j] = 1;
                    backTrack(i + 1, s, result + s.charAt(j));
                    dd[j] = 0;
                }

            }
        }
    }

}