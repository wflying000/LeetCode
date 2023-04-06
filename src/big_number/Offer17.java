import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer17 {
    private int[] nums;
    private int[] res;
    private int index = 0;
    private List<Integer> list = new ArrayList<>();

    public int[] printNumbers(int n) {
        int m = (int)Math.pow(10, n) - 1;
        res = new int[m];
        nums = new int[n];
        for (int i = 1; i <= n; i++) { // 遍历1位数，2位数直到n位数
            dfs(0, i);
        }
        
        return res;
    }

    private void dfs(int k, int n) {
        if (k == n) {
            res[index++] = convertDigitToNum(nums, n);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (k == 0 && i == 0) { //最高位不能为0
                continue;
            }
            nums[k] = i;
            dfs(k + 1, n);
        }
    }

    private int convertDigitToNum(int[] nums, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res * 10 + nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Offer17 sln = new Offer17();
        int n = 3;
        int[] res = sln.printNumbers(n);
        System.out.println(Arrays.toString(res));
    }
}