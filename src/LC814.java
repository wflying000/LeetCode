public class LC814 {
    public TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }

    private TreeNode prune(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = prune(root.left);
        root.right = prune(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    private int prune2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = prune2(root.left);
        int right = prune2(root.right);
        if (left == 0) {
            root.left = null;
        }
        if (right == 0) {
            root.right = null;
        }
        return root.val + left + right;
    }
}
