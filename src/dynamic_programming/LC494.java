public class LC494 {
    public int findTargetSumWays2(int[] nums, int target) {
        int[] res = {0};
        dfs(nums, 0, target, res);
        return res[0];
    }

    private void dfs(int[] nums, int index, int target, int[] res) {
        if (index == nums.length) {
            if (target == 0) {
                res[0] += 1;
            }
            return;
        }
        dfs(nums, index + 1, target - nums[index], res);
        dfs(nums, index + 1, target + nums[index], res);
    } 

    public int findTargetSumWays3(int[] nums, int target) {
        //代码不对
        //初始化有问题
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[n][neg + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;  //不一定为1, nums[0 .. i]中如果有相等的数或多个0，则组成0有多种方案
        }
        if (nums[0] <= neg) {
            dp[0][nums[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n - 1][neg];
    } 

    public int findTargetSumWays4(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][neg];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = neg; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            } 
        }

        return dp[neg];
    }
}