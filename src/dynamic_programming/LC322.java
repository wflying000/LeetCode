public class LC322 {
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = max;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int tmp = max;
                if (j >= coins[i] && dp[i][j - coins[i]] != max) {
                    // 因为每种硬币可以选多个，因此选择coins[i]则等价于至少选
                    // 一个coins[i], 因此通过coins[0 .. i]组成j-coins[i]（这里可能也选了coins[i]）
                    // 最后选择一个coins[i],共同组成j，完成至少选一个coins[i]的方案
                    tmp = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j], tmp);
            }
        }

        return dp[n - 1][amount] == max ? -1 : dp[n - 1][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[j] = j / coins[0];
            } else {
                dp[j] = max;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int tmp = max;
                if (j >= coins[i] && dp[j - coins[i]] != max) {
                    tmp = dp[j - coins[i]] + 1;
                }
                dp[j] = Math.min(dp[j], tmp);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
