import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    } 
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void print(TreeNode root) {
        //按照层序遍历打印
        if (root == null) {
            System.out.println("[]");
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                str.append("null, ");
            } else {
                str.append(node.val + ", ");
                if (node.left != null || node.right != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        str.delete(str.length() - 2, str.length()); //删除最后的逗号和空格", "
        str.append("]");
        System.out.println(str);
    }
}
