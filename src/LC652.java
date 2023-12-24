import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC652 {

    private class Pair {
        TreeNode key;
        Integer value;

        public Pair(TreeNode key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public TreeNode getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }
    }

    Map<String, Pair> map = new HashMap<>();
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
            Pair pair = map.get(str);
            set.add(pair.getKey());
            return pair.getValue();
        } else {
            map.put(str, new Pair(root, ++idx));
            return idx;
        }

    }
}
