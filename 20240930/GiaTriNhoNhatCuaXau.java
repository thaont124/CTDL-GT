import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GiaTriNhoNhatCuaXau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int k = scanner.nextInt();
            String s = scanner.next();
            Map<Character, Integer> map = new HashMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }
            for (Character x : map.keySet()) {
                pq.add(map.get(x));
            }
            while (k > 0 && !pq.isEmpty()) {
                int maxx = pq.poll();
                pq.add(maxx - 1);
                k--;
            }
            int sum = 0;
            for (Integer x : pq) {
                sum += x * x;
            }
            System.out.println(sum);
        }
    }
}
