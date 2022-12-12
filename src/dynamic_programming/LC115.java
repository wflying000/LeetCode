public class LC115 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public int numDistinct2(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 对于赋值运算符右侧的dp[j], 此时dp[j]还未更新，因此这个dp[j]表示上一轮计算出的dp[j]，对应二维数组表示中的dp[i - 1][j]
                    // 对于dp[j - 1], 由于j是从大到小遍历，此时dp[j - 1]还未更新，因此dp[j - 1]表示上一轮计算的dp[j - 1],对应二位数组表示中的dp[i - 1][j - 1]
                    dp[j] = dp[j] + dp[j - 1];
                }
                /*
                else {
                    对于二维数组的情况，dp[i][j]需要继承上一轮的值即dp[i - 1][j],
                    而对于一维数组的情况，dp[j]在不更新的情况下即为上一轮计算的值
                    因此这种情况不需要处理                    
                }
                */
            }
        }
        return dp[n];
    }
}