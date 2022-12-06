public class LC926 {
    public static int minFlipsMonoIncr2(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        if (s.charAt(0) == '0') {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int one = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                one = Math.min(zero, one) + 1;
            } else {
                //以下两行顺序不能换，计算one需要上一次的one和zero
                //因此先用未更新的zero，然后再更新zero
                one = Math.min(zero, one);
                zero++;
            }
        }
        return Math.min(one, zero);
    }

    public static void main(String[] args) {
        String s = "00011000";
        int res = minFlipsMonoIncr(s);
        System.out.println(res);
    }
}
