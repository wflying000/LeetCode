import java.util.Random;

public class LC215 {
    private static Random rand = new Random();

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, n - k, 0, n - 1);
    }

    private static int quickSelect(int[] nums, int index, int left, int right) {
        int pos = randomPartition(nums, left, right);
        if (pos == index) {
            return nums[pos];
        }
        return pos < index ? quickSelect(nums, index, pos + 1, right) : quickSelect(nums, index, left, pos - 1);
    }

    private static int randomPartition(int[] nums, int left, int right) {
        int idx = rand.nextInt(right - left + 1) + left;
        swap(nums, left, idx);
        return partition(nums, left, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int x = nums[left];
        while (left < right) {
            while (left < right && nums[right] > x) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= x) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = x;
        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int res = findKthLargest(nums, k);
        System.out.println(res);
    }
}
