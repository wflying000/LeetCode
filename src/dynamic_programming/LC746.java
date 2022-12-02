package dynamic_programming;

public class LC746 {
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = 0;
        int prev2 = 0;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = Math.min(prev2 + cost[i - 2], prev1 + cost[i - 1]);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}
