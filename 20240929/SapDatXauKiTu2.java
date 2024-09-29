import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SapDatXauKiTu2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            Map<Character, Integer> map = new HashMap<>();
            int d = scanner.nextInt();
            String s = scanner.next();

            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }

            int cntMax = -1;
            for (Character key : map.keySet()) {
                if (map.get(key) > cntMax) {
                    cntMax = map.get(key);
                }

            }
            // System.out.println(map);
            if (((cntMax - 1) * (d - 1) > s.length() - cntMax) || (map.size() - 1) < (d - 1)) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        }
    }
}
