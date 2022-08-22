public class LC724 {
    public int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int rsum = 0;
        for (int i = 0; i < nums.length; i++) {
            rsum += nums[i];
        }
        int lsum = 0;
        for (int i = 0; i < nums.length; i++) {
            rsum -= nums[i];
            if (lsum == rsum) {
                return i;
            }
            lsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int res = new LC724().pivotIndex(nums);
        System.out.println(res);
    }
}