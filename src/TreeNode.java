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
        int i = str.length() - 1;
        while (!Character.isDigit(str.charAt(i))) {
            i--;
        }
        str.delete(i + 1, str.length());
        str.append("]");
        System.out.println(str);
    }

    public static TreeNode buildTree(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            if (i >= strs.length) {
                break;
            }
            TreeNode node = queue.poll();
            if (!strs[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.left);
            }
            i++;
            if (i >= strs.length) {
                break;
            }
            if (!strs[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        String[] strs = {"1", "3", "2", "5", "null", "null", "9", "6", "null", "7"};
        TreeNode root = buildTree(strs);
        print(root);
    }
}
