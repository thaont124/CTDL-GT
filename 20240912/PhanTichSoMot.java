import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PhanTichSoMot {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int test = scanner.nextInt();
            while (test-- > 0) {
                int n = scanner.nextInt();

                List<List<Integer>> results = analyze(n);
                for (List<Integer> result : results) {
                    System.out.println(result.toString());
                }
            }
        }
    }

    private static List<List<Integer>> analyze(int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = Arrays.asList(n);

        while (list.size() < n) {
            results.add(list);
            System.out.println(list.toString());
            list = nextGeneration(n, list);
        }
        results.add(list);
        return results;
    }

    private static List<Integer> nextGeneration(int n, List<Integer> list) {
        list = new ArrayList<>(list);
        // System.out.println("list before: " + list.toString());
        int i = list.size() - 1;
        while (list.get(i) == 1) {
            list.remove(i);
            i--;
        }
        // System.out.println("list: " + list.toString());
        list.set(i, list.get(list.size() - 1) - 1);

        int sum = n;
        for (int j = 0; j <= i; j++) {
            sum -= list.get(j);
        }
        int k = list.get(list.size() - 1);
        while (sum > 0) {
            if (sum - k < 0) {
                k--;
            } else {
                list.add(k);
                sum -= k;
            }
        }

        return list;
    }
}
