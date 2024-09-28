import java.util.*;

class Job {
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.deadline = deadline;
        this.id = id;
        this.profit = profit;
    }

    public String toString() {
        return "(" + id + " " + deadline + ", " + profit + ")";
    }
}

public class SapXepCongViec2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Job> jobs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int dl = scanner.nextInt();
                int profit = scanner.nextInt();
                jobs.add(new Job(x, dl, profit));
            }
            Collections.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
            System.out.println(jobs);
            int total = 0;
            int cnt = 0;
            int[] check = new int[10001];

            for (int i = 0; i < n; i++) {
                while (jobs.get(i).deadline > 0 && check[jobs.get(i).deadline] == 1) {
                    jobs.get(i).deadline--;
                }

                if (jobs.get(i).deadline > 0 && check[jobs.get(i).deadline] == 0) {
                    check[jobs.get(i).deadline] = 1;
                    total += jobs.get(i).profit;
                    cnt++;
                    // System.out.println(jobs.get(i));
                }
            }
            System.out.println(cnt + " " + total);
        }
    }
}
