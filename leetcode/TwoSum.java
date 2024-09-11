import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numsAndIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numsAndIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (numsAndIndex.containsKey(y)) {
                if (numsAndIndex.get(y) != i) {
                    result[0] = i;
                    result[1] = numsAndIndex.get(y);
                    break;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = { 3, 2, 4 };
        int target = 6;

        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Chỉ số của hai phần tử có tổng bằng " + target + " là: " + result[0] + " và " + result[1]);
    }
}
