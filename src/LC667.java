public class LC667 {
    // n个数构造相邻数恰好有k个不同的差值
    // 通过 [1, n - 1, 2, n - 2, ...]的顺序构造k-1个差值, 剩余一个差值通过相邻数构造1这个差值
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int i = 2;
        int j = n;
        int idx = 1;
        res[0] = 1;
        boolean right = true;
        for (int t = 0; t < k - 1; t++) {
            if (right) {
                res[idx++] = j--;
            } else {
                res[idx++] = i++;
            }
            right = !right;
        }

        // 构造差值都为1的序列
        if (right) { //right == true, 说明最后放入数组的是较小的数, 因此后续序列需要升序
            while (idx < n) {
                res[idx++] = i++;
            }
        } else {
            while (idx < n) { // right == false, 说明最后放入数组的是较大的数，后续序列需要降序
                res[idx++] = j--;
            }
        }
        
        return res;
    }
}
