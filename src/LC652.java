import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

public class LC652 {
    Map<String, Pair<TreeNode, Integer>> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(set);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] tri = {root.val, dfs(root.left), dfs(root.right)};
        String str = Arrays.toString(tri);
        if (map.containsKey(str)) {
            Pair<TreeNode, Integer> pair = map.get(str);
            set.add(pair.getKey());
            return pair.getValue();
        } else {
            map.put(str, new Pair<>(root, ++idx));
            return idx;
        }

    }
}
