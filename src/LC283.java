import java.util.Arrays;

public class LC283 {
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                count++;
            }
        }
        if (count == nums.length) {
            return;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx >= count) {
                nums[idx++] = 0;
            } else if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
