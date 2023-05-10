public class Lc98 {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // boolean left = valid(root.left, root, null, root.val);
        // boolean right = valid(root.right, root, root.val, null);
        return valid2(root, null, null);
    }

    private static boolean valid2(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if (low != null && root.val <= low) {
            return false;
        } 
        if (high != null && root.val >= high) {
            return false;
        }
        boolean left = valid2(root.left, low, root.val);
        boolean right = valid2(root.right, root.val, high);
        return left && right;
    }

    private static boolean valid(TreeNode root, TreeNode p, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if (low != null && root.val <= low) {
            return false;
        } 
        if (high != null && root.val >= high) {
            return false;
        } 
        if (root == p.left && root.val >= p.val) {
            return false;
        } 
        if (root == p.right && root.val <= p.val) {
            return false;
        }

        if (root == p.left) {
            high = p.val;
        }
        if (root == p.right) {
            low = p.val;
        }

        boolean left = valid(root.left, root, low, high);
        boolean right = valid(root.right, root, low, high);
        return left && right;
    }

    public static void main(String[] args) {
        String[] strs = {"5", "1", "7", "null", "null", "3", "8"};
        TreeNode root = TreeNode.buildTree(strs);
        boolean res = isValidBST(root);
        System.out.println(res);
    }
}
