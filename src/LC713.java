public class LC713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int res = 0;
        int prod = 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (left <= i && prod >= k) {
                prod /= nums[left];
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        int res = new LC713().numSubarrayProductLessThanK(nums, k);
        System.out.println(res);
    }
}
