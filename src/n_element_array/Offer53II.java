public class Offer53II {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int res = right + 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else { // mid < nums[mid]
                res = mid;
                right = mid - 1;
            }
        }
        return res;

        // 对于数0, 1, 2, ... n - 2, n - 1按递增顺序排在大小为n - 1的数组中nums[i]
        // 假设缺少的数为x
        // 则对于小于x的数 s，它们的索引即为s, 即nums[s] = s
        // 对于大于x的数 t，它们的索引为t - 1, 即nums[t - 1] = t
        // 对于x + 1, 它是第一个大于自己坐标的数，nums[x] = x + 1
        // 因此找到第一个大于自身坐标的数，它的坐标即是缺少的数，
        // 由于数组递增因此可以通过二分查找实现
    }
}
