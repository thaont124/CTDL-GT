package sort;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            int count = countMap.getOrDefault(num, 0);
            if (count > (nums.length / 2)) {
                return num;
            }
        }
        return 0;
    }
}
