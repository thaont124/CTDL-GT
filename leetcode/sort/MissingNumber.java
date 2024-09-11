package sort;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum_of_n = (n * (n + 1)) / 2;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        return sum_of_n - total;
    }

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] nums = { 3, 0, 1 };
        System.out.println(m.missingNumber(nums));
    }
}
