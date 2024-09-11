package sort;

import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] result = new int[intervals.length][2];
        int[] crt = intervals[0];
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (crt[0] <= interval[0] && interval[0] <= crt[1] && crt[0] <= interval[1] && interval[1] <= crt[1]) {
                continue;
            } else if (crt[0] <= interval[0] && interval[0] <= crt[1]) {
                // crt[0] = crt[0];
                crt[1] = interval[1];
                System.out.println(Arrays.toString(crt));
            } else {
                result[idx++] = crt;
                crt = interval;
            }
        }
        result[idx++] = crt;
        return Arrays.copyOf(result, idx);

    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 0, 2 }, { 3, 5 } };

        MergeIntervals m = new MergeIntervals();
        int[][] result = m.merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
