package dynamic_programming;

public class LC256 {
    public int minCost2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int r = Math.min(blue, green) + costs[i][0];
            int b = Math.min(red, green) + costs[i][1];
            int g = Math.min(red, blue) + costs[i][2];
            red = r;
            blue = b;
            green = g;
        }
        return Math.min(Math.min(red, blue), green);
    }
}
