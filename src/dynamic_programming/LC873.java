package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class LC873 {
    public static int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> num2idx = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            num2idx.put(arr[i], i);
        }
        int res = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = num2idx.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                res = Math.max(res, dp[j][i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int res = lenLongestFibSubseq(arr);
        System.out.println(res);
    }

}
