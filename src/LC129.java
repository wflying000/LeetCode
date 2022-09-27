public class LC129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        int num = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
        }
        dfs(root.left, num);
        dfs(root.right, num);
    }
}
