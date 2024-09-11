
import java.util.ArrayList;
import java.util.List;

public class FindSubarrays {
    /*
     * Description
     * Given a 0-indexed integer array nums, determine whether there exist two
     * subarrays of length 2 with equal sum. Note that the two subarrays must begin
     * at different indices.
     * 
     * Return true if these subarrays exist, and false otherwise.
     * 
     * Example 1:
     * Input: nums = [4,2,4]
     * Output: true
     * Explanation: The subarrays with elements [4,2] and [2,4] have the same sum of
     * 6
     * 
     * Example 2:
     * Input: nums = [1,2,3,4,5]
     * Output: false
     * Explanation: No two subarrays of size 2 have the same sum.
     */

    // Ví dụ dung HashMap thif code chayj nhanh honw??
    // public boolean findSubarrays(int[] nums) {

    // HashSet<Integer> set = new HashSet<>();
    // for(int i=0; i<nums.length-1;i++){
    // int sum = nums[i]+nums[i+1];
    // if(set.contains(sum)){
    // return true;
    // }else{
    // set.add(sum);
    // }

    // }
    // return false;
    // }

    public boolean findSubarrays(int[] nums) { // kq chạy: 4ms
        List<Integer> sumList = new ArrayList<>(); // [tổng đã có]

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            System.out.println(sum);
            if (sumList.contains(sum)) {
                return true;
            } else {
                sumList.add(sum);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        FindSubarrays f = new FindSubarrays();
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(f.findSubarrays(nums));
    }

}
