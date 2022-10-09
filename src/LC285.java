import java.util.ArrayDeque;
import java.util.Deque;

public class LC285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == p) {
                return root;
            }
            pre = root;
            root = root.right;
        }
        return null;
    }
}
