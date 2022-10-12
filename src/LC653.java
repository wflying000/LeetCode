import java.util.ArrayList;
import java.util.List;

public class LC653 {
    List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum < k) {
                i++;
            } else if (sum > k) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
