public class KthMagicNumber {
    // LeetCode 面试题 17.09. 第 k 个数
    // 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
    // 注意，不是必须有这些素因子，而是必须不包含其他的素因子。
    // 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

    public int getKthMagicNumber(int k) {
        int[] nums = new int[k];
        nums[0] = 1;
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        for (int i = 1; i < k; i++) {
            int num3 = nums[p3] * 3;
            int num5 = nums[p5] * 5;
            int num7 = nums[p7] * 7;
            int num = Math.min(Math.min(num3, num5), num7);
            nums[i] = num;
            if (num == num3) {
                p3++;
            }
            if (num == num5) {
                p5++;
            }
            if (num == num7) {
                p7++;
            }
        }
        return nums[k - 1];
    }
}
