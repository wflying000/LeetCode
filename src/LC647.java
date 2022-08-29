public class LC647 {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = n;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res += 1;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n + 1 - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
