
import java.util.PriorityQueue;
import java.util.Scanner;

public class NoiDay1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                pq.add(x);
            }

            int cost = 0;
            while (pq.size() > 1) {
                int first = pq.poll();
                int second = pq.poll();
                int len = first + second;
                cost = cost + len;
                pq.add(len);
            }
            System.out.println(cost);
        }

    }
}
