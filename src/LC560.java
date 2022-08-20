import java.util.HashMap;
import java.util.Map;

public class LC560 {
    public int subarraySum1(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //子数组从下标0开始时需要用到
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LC560 sln = new LC560();
        int[] nums = {1, 2, 3};
        int k = 3;
        int res1 = sln.subarraySum1(nums, k);
        int res2 = sln.subarraySum2(nums, k);
        System.out.println(res1);
        System.out.println(res2);
    }
}
