import java.util.Arrays;

public class SetFront {
    public static void setFront(int[] nums, int value) {
        int n = nums.length;
        int i = n - 1;
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] != value) {
                nums[i--] = nums[j];
            }
        }
        for (int j = 0; j <= i; j++) {
            nums[j] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 6, 1, 1, 2, 3, 1, 2, 1};
        setFront(nums, 1);
        System.out.println(Arrays.toString(nums));
    }
}