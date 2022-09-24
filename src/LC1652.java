public class LC1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        int[] sum = new int[n];
        sum[0] = code[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + code[i];
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int postEnd = Math.min(i + k, n - 1);
                res[i] = sum[postEnd] - sum[i];
                if (k - postEnd + i > 0) {
                    res[i] += sum[k - postEnd + i - 1];
                }
            }
        } else {
            k = -k;
            res[0] = sum[n - 1] - sum[n - k - 1];
            for (int i = 1; i < n; i++) {
                int preStart = Math.max(i - k, 0);
                int numPre = i - preStart;
                if (numPre == k) {
                    if (preStart == 0) {
                        res[i] = sum[i - 1];
                    } else {
                        res[i] = sum[i - 1] - sum[preStart - 1];
                    }
                } else {
                    int numPost = k - numPre;
                    res[i] = sum[i - 1] + sum[n - 1] - sum[n - numPost - 1];
                }
            }
        }
        return res;
    }
}
