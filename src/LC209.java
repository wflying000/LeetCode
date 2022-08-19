public class LC209 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (sum >= target) {
                res = Math.min(res, j - i + 1);
                if (i == j) {
                    i++;
                    j++;
                    if (j < nums.length) {
                        sum = nums[i];
                    }
                } else {
                    sum -= nums[i];
                    i++;
                }
            } else {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                }
            }
        }
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int target = 4;
        int[] nums = {1, 4, 4};
        int res = new LC209().minSubArrayLen(target, nums);
        System.out.println(res);
    }
}
