
import java.util.PriorityQueue;
import java.util.Scanner;

public class NoiDay2 {
    static long mod = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                long x = scanner.nextLong();
                pq.add(x);
            }

            long cost = 0;
            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();
                long len = (first + second) % mod;
                cost = (cost + len) % mod;
                pq.add(len);
            }
            System.out.println(cost);
        }

    }
}