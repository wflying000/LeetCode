import java.util.List;
import java.util.ArrayList;


public class LC78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, list, res);
        return res;
    }

    private static void backtrack(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        backtrack(nums, index + 1, list, res);

        list.add(nums[index]);
        backtrack(nums, index + 1, list, res);
        list.remove(list.size() - 1);
    }

    public static List<List<Integer>> subsets_iterative(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            list.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    list.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
}