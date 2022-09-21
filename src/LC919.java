import java.util.LinkedList;
import java.util.Queue;

public class LC919 {
    TreeNode root;
    Queue<TreeNode> queue;
    public LC919(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
            if (node.left == null || node.right == null) {
                queue.offer(node);
            }
        }
    }
    
    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode newnode = new TreeNode(v);
        if (node.left == null) {
            node.left = newnode;
        } else {
            node.right = newnode;
            queue.poll();
        }
        queue.offer(newnode);
        return node.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
