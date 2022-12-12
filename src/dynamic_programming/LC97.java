package dynamic_programming;

public class LC97 {
    public static boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        if (m + n != t) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k));
                }
                if (j > 0 && !dp[i][j]) {
                    dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
            }
        }
        return dp[m][n];
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && (s1.charAt(i - 1) == s3.charAt(k)); // 此时正在更新dp[j], 因此赋值运算符右侧的dp[j]为还未更新的,即i- 1时计算出的dp[j], 对应二维数组的dp[i - 1][j]
                }
                
                if (j > 0 && !dp[j]) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k); // 此时更新dp[j], 而dp[j - 1]在dp[j]之前更新。因此dp[j - 1]对应二维数组的dp[i][j - 1]
                }
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean res = isInterleave2(s1, s2, s3);
        System.out.println(res);

    }
}
