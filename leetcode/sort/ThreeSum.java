package sort;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    // example for faster
    public List<List<Integer>> fasterthreeSum(int[] nums) {
        return new AbstractList<>() {
            List<List<Integer>> ans;

            public int size() {
                if (ans == null)
                    init();
                return ans.size();
            }

            public List<Integer> get(int i) {
                if (ans == null)
                    init();
                return ans.get(i);
            }

            private void init() {
                Set<List<Integer>> res = new HashSet<>();
                Arrays.sort(nums);
                int n = nums.length;
                for (int i = 0; i < n - 2; i++) {
                    int left = i + 1;
                    int right = n - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[left] + nums[right];
                        if (sum == 0) {
                            res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                            left++;
                            right--;
                        } else if (sum < 0)
                            left++;
                        else
                            right--;
                    }
                }
                ans = new ArrayList<>(res);
            }
        };

    }

    public static void main(String[] args) {
        ThreeSum threeSumArr = new ThreeSum();
        // int[] arr = { -2, 0, 1, 1, 2 };
        // int[] arr = { -1, 0, 1, 0 };
        // int[] arr = { -1, 0, 1, 2, -1, -4 };
        int[] arr = { 0, 0, 0, 0 };

        System.out.println(threeSumArr.threeSum(arr));
    }
}
