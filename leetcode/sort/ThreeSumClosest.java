package sort;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int output = nums[0] + nums[1] + nums[2]; // Khởi tạo kết quả gần nhất ban đầu

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // Nếu tìm thấy tổng đúng bằng target, trả về ngay lập tức
                if (sum == target) {
                    return sum;
                }

                // Cập nhật output nếu tổng mới gần hơn
                if (Math.abs(sum - target) < Math.abs(output - target)) {
                    output = sum;
                }

                // Di chuyển con trỏ j hoặc k để tiếp tục tìm kiếm
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumArr = new ThreeSumClosest();
        int[] arr = { 4, 0, 5, -5, 3, 3, 0, -4, -5 };
        int target = -2;
        System.out.println(threeSumArr.threeSumClosest(arr, target));
    }
}

// // much faster
// class Solution {
// public int threeSumClosest(int[] nums, int target) {
// byte[] occurrences = new byte[2001];
// for (int num : nums)
// occurrences[num + 1000]++;
// for (int count = 0, index = 0; count < 2001; count++)
// for (int repetitions = occurrences[count]; repetitions-- > 0;)
// nums[index++] = count - 1000;
// int low = 0, high = nums.length - 1, closestSum = Integer.MAX_VALUE;
// for (int minDiff = target - nums[high - 1] - nums[high], end = high - 2; low
// < end
// && nums[low + 1] <= minDiff; low++)
// ;
// for (int maxDiff = target - nums[low] - nums[low + 1], end = low + 2; high >
// end
// && nums[high - 1] >= maxDiff; high--)
// ;
// for (int end = high - 1; low < end; low++)
// for (int sum, i = high, j = low + 1; j < i;)
// if ((sum = nums[low] + nums[i] + nums[j]) == target)
// return sum;
// else if ((sum > target ? sum - target - i + i-- : target - sum - j + j++) <
// Math
// .abs(closestSum - target))
// closestSum = sum;
// return closestSum;
// }
// }