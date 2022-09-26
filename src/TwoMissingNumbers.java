public class TwoMissingNumbers {
    // 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。
    // 你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
    // 以任意顺序返回这两个数字均可。

    //假设缺失的两个数字分别是num1和num2, 
    //数组nums的长度为N - 2
    //对于假设有一个虚拟数组dummy为[1...N] + nums
    //对于1-N中的数，除了num1和num2之外所有数字都出现了两次
    //令xor=0, 将xor与dummy中所有元素做异或运算，最后的结果xor=num1 ^ num2, xor !=0
    //因为相同的数字异或为0, 找出xor二进制表示不为0的最低位，假设该为为从左往右数第low位(最左边为第0位)
    //因为xor二进制第low位为1,则num1,num2的第low位一个为0一个为1
    //按照第low位为0与1, 可以将dummy数组的元素分成两组，num1和num2在不同的组，
    //每组中除了num1或num2之外，其他所有数字都出现两次
    //对每组中所有元素分别进行异或运算，两组最后的结果就是num1与num2
    public int[] missingTwo(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }
        for (int i = 1; i <= n + 2; i++) {
            xor = xor ^ i;
        }
        int k = 1;
        for (int i = 0; i < 31; i++) {
            if ((xor & k) != 0) {
                break;
            }
            k = k << 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & k) == 0) {
                num1 = num1 ^ nums[i];
            } else {
                num2 = num2 ^ nums[i];
            }
        }
        for (int i = 1; i <= n + 2; i++) {
            if ((i & k) == 0) {
                num1 = num1 ^ i;
            } else {
                num2 = num2 ^ i;
            }
        }
        return new int[] {num1, num2};
    }
}
