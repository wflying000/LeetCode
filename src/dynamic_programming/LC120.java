import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }

        int res = dp[m - 1][0];
        for (int j = 1; j < n; j++) {
            res = Math.min(res, dp[m - 1][j]);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(3);list.add(4);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(6);list.add(5);list.add(7);
        triangle.add(new ArrayList<>(list));
        list.clear();
        list.add(4);list.add(1);list.add(8);list.add(3);
        triangle.add(new ArrayList<>(list));

        int res = minimumTotal(triangle);
        System.out.println(res);
    }
}
