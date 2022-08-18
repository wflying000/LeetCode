import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = n - 1;
            int target = -nums[i];
            for (int j = i + 1; j < k; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] > target) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new LC15().threeSum(nums);
        System.out.println(res);
    }
}
