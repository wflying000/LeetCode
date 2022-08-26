// 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
// 请你计算并返回该式的最大值。
// 1 <= nums[i] <= 1e3
// https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array


public class LC1464 {
    
    //维护一个最大数
    public int maxProduct1(int[] nums) {
        int max = nums[0] - 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i] - 1;
            res = Math.max(res, max * num);
            max = Math.max(max, num);
        }
        return res;
    }

    //维护最大数和次大数
    public int maxProduct2(int[] nums) {
        int max = nums[0] - 1;
        int sub = nums[1] - 1;
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i] - 1;
            if (num > max) {
                sub = max;
                max = num;
            } else if (num > sub) {
                sub = num;
            }
        }
        return max * sub;
    }

    //原题中nums[i] > 1, 如果数组中出现负数, 以下方法可求(nums[i] - 1) * (nums[j] - 1)的最大值
    public int maxProduct3(int[] nums) {
        int max = nums[0] - 1;
        int min = nums[0] - 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i] - 1;
            res = Math.max(res, max * num);
            res = Math.max(res, min * num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return res;
    }

    public static void main(String[] args) {
        LC1464 sln = new LC1464();
        int[] nums = {-3, -2, -1, 0, 1, 2};
        int res = sln.maxProduct3(nums);
        System.out.println(res);
    }
}
