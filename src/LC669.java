public class LC669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) { // 如果root.val < low 则root及root.left都修剪, 返回root.right的修剪结果
            return trimBST(root.right, low, high);
        } else if (root.val > high) { // 如果root.val > high 则root及root.right都修剪, 返回root.left的修改结果
            return trimBST(root.left, low, high);
        }
        //root满足条件, 分别修剪root.left和root.right并返回root
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;

    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        while ((root != null) && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node.left != null) {
            if (node.left.val < low) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }
        node = root;
        while (node.right != null) {
            if (node.right.val > high) {
                node.right = node.right.left;
            } else {
                node = node.right;
            }
        }
        return root;
    }
}
