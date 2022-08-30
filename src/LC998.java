public class LC998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        TreeNode pre = root;
        TreeNode cur = root.right;
        while (cur != null) {
            if (cur.val > val) {
                pre = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        TreeNode node = new TreeNode(val);
        node.left = pre.right;
        pre.right = node;
        return root;
    }
}
