import java.util.arrayList;
import java.util.List;
import java.util.Scanner;

public class SoNguyenTo {
    static List<Integer> result;
    static List<List<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int s = sc.nextInt();
            result = new arrayList<>();
            list = new arrayList<>();

            backTrack(n, p + 1, s);
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    private static void backTrack(int n, int p, int s) {
        if (result.size() == n && s == 0) {
            list.add(new arrayList<>(result));
        }

        for (int i = p; i <= s; i++) {
            if (i % 2 == 0 && i != 2) {
                continue;
            }
            if (isPrime(i)) {
                result.add(i);
                backTrack(n, i + 1, s - i);
                result.remove(result.size() - 1);
            }
        }
    }

    private static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }

        if (x == 2) {
            return true;
        }
        if (x % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
