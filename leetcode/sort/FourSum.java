package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int r = nums.length - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (l < r) {
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[l] + " " + nums[r]);
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];

                    System.out.println(sum);
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && nums[r] == nums[r - 1])
                            r--;

                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        FourSum fourSumArr = new FourSum();
        // int[] arr = { -2, 0, 1, 1, 2 };
        // int[] arr = { -1, 0, 1, 0 };
        // int[] arr = { -1, 0, 1, 2, -1, -4 };
        int[] arr = { 1000000000, 1000000000, 1000000000, 1000000000 };
        int target = -294967299;

        System.out.println(fourSumArr.fourSum(arr, target));
    }
}
