import java.util.Arrays;

public class LC1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= n - i) {
                if (i > 0) {
                    if (nums[i - 1] < n - i) {
                        return n - i;
                    }
                } else {
                    return n - i;
                }
            }
        }
        return -1;
    }
}
