import java.util.ArrayDeque;
import java.util.Deque;

public class LC897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode res = null;
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (res != null) {
                root.left = null;
                pre.right = root;
            } else {
                res = root;
            }
            pre = root;
            root = root.right;
        }
        return res;
    }
}
