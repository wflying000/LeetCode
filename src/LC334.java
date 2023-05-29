public class LC334 {
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        } 
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, -2, 6};
        boolean res = increasingTriplet(nums);
        System.out.println(res);
    }
}
