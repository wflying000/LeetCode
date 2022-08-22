import java.util.List;
import java.util.ArrayList;

public class LC655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int m = height;
        int n = (int)Math.pow(2, height) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            res.add(list);
        }
        print(root, 0, (n - 1)/2, height, res);
        return res;
    }

    private void print(TreeNode root, int r, int c, int h, List<List<String>> res) {
        res.get(r).set(c, root.val + "");
        if (root.left != null) {
            int lchildr = r + 1;
            int lchildc = c - (int)Math.pow(2, h - r -2);
            print(root.left, lchildr, lchildc, h, res);
        }
        if (root.right != null) {
            int rchildr = r + 1;
            int rchildc = c + (int)Math.pow(2, h - r - 2);
            print(root.right, rchildr, rchildc, h, res);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
