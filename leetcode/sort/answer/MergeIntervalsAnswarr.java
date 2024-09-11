package sort.answer;

import java.util.*;

public class MergeIntervalsAnswarr {
    public int[][] mergeWithoutSortFirst(int[][] intervals) {

        // edge case
        if (intervals.length <= 1)
            return intervals;

        int max = -1;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(intervals[i][0], max);
        }
        if (max == -1) {
            return new int[][] { intervals[0] };
        }
        int[] timeTable = new int[max + 1];
        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
        }
        int resultSize = 0, currEnd = -1, currStart = -1;
        for (int i = 0; i < timeTable.length; i++) {
            if (timeTable[i] != 0) {
                if (currStart == -1) {
                    currStart = i;
                }
                currEnd = Math.max(timeTable[i] - 1, currEnd);
            }
            if (currEnd == i) {
                intervals[resultSize++] = new int[] { currStart, currEnd };
                currEnd = -1;
                currStart = -1;
            }
        }
        if (currStart != -1) {
            intervals[resultSize++] = new int[] { currStart, currEnd };
        }
        if (intervals.length == resultSize) {
            return intervals;
        }
        int[][] res = new int[resultSize][];
        for (int i = 0; i < resultSize; i++) {
            res[i] = intervals[i];
        }
        return res;

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] i : intervals) {
            if (list.isEmpty() || list.getLast()[1] < i[0]) {
                list.add(i);
            } else {
                list.getLast()[1] = Math.max(i[1], list.getLast()[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
