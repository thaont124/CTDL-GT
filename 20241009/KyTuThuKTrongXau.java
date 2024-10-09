import java.util.Scanner;

public class KyTuThuKTrongXau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(find(n, k - 1));
        }
    }

    private static char find(int n, int k) {
        int len = (int) Math.pow(2, n) - 1;
        int mid = len / 2;
        System.out.println(len + " " + k + " " + mid);

        if (k == mid) {
            return (char) ('A' + n - 1);
        }
        if (k < mid) {
            return find(n - 1, k);
        }
        return find(n - 1, len - k);
    }
}
