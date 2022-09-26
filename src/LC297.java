import java.util.LinkedList;
import java.util.Queue;

public class LC297 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#_";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#_");
            } else {
                sb.append(cur.val + "_");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("_");
        if (strs[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (i >= strs.length) {
                break;
            }
            TreeNode cur = queue.poll();
            if (!strs[i].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(cur.left);
            }
            i++;
            if (i > strs.length) {
                break;
            }
            if (!strs[i].equals("#")) {
                cur.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}
