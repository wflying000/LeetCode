import java.util.ArrayList;
import java.util.List;

public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, list, res);
        return res;
    }

    private void backtrack(int num, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() + (n - num + 1) < k) {
            return;
        }
        backtrack(num + 1, n, k, list, res);

        list.add(num);
        backtrack(num + 1, n, k, list, res);
        list.remove(list.size() - 1);
    }
}
