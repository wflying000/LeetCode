public class LC1143 {
    public static String longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return "";
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char ch = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (text2.charAt(j - 1) == ch) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i -= 1;
                j -= 1;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i -= 1;
            } else {
                j -= 1;
            }
        }
        sb.reverse();
        String res = sb.toString();

        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        String lcs = longestCommonSubsequence(s1, s2);
        System.out.println(lcs);
    }
}