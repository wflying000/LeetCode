import java.util.Arrays;

public class LC1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i + n];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 10, 20, 30, 40};
        int n = nums.length / 2;
        LC1470 sln = new LC1470();
        int[] res = sln.shuffle(nums, n);
        System.out.println(Arrays.toString(res));
    }
}