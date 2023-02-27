public class Offer03 {
    public static int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            i++;
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int res = findRepeatNumber(nums);
        System.out.println(res);
    }
}