import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SoKhoiLapPhuong {
    public static boolean check(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for (char c : map1.keySet()) {
            if (map1.get(c) > map2.getOrDefault(c, 0)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSmaller(String num1, String num2) {
        return num1.length() < num2.length() || (num1.compareTo(num2) < 0 && num1.length() == num2.length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<String> f = new ArrayList<>();

        for (long i = 1; i <= 1000000; i++) {
            f.add(String.valueOf(i * i * i));
        }
        while (t-- > 0) {
            String s = scanner.next();
            String ans = "-1";

            for (int i = f.size() - 1; i >= 0; i--) {
                if (isSmaller(f.get(i), s) && check(f.get(i), s)) {
                    ans = f.get(i);
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
