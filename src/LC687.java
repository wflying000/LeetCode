public class LC687 {
    private int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root);
        return res;
    }

    private int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left =  process(node.left);
        int validLeft = 0;
        if (node.left != null && node.left.val == node.val) {
            validLeft = left + 1;
        }
        int right = process(node.right);
        int validRight = 0;
        if (node.right != null && node.right.val == node.val) {
            validRight = right + 1;
        }
        res = Math.max(res, validLeft + validRight);

        return Math.max(validLeft, validRight);
    }

    public static void main(String[] args) {
        String[] strs = {"1", "4", "5", "4", "4", "5"};
        TreeNode root = TreeNode.buildTree(strs);
        LC687 sln = new LC687();
        int res = sln.longestUnivaluePath(root);
        System.out.println(res);
    }
}
