package dynamic_programming;

public class LC1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch1 = text1.charAt(i - 1);
                char ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        char ch = text1.charAt(0);
        for (int j = 0; j < n; j++) {
            if (text2.charAt(j) == ch) {
                dp[0][j] = 1;
            } else if (j > 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        ch = text2.charAt(0);
        for (int i = 0; i < m; i++) {
            if (text1.charAt(i) == ch) {
                dp[i][0] = 1;
            } else if (i > 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char ch1 = text1.charAt(i);
                char ch2 = text2.charAt(j);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
